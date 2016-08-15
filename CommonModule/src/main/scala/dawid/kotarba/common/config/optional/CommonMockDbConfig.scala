package dawid.kotarba.common.config.optional

import java.util.Properties
import javax.inject.Inject
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

import org.h2.server.web.WebServlet
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.embedded.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.core.io.Resource
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver
import org.springframework.jdbc.datasource.embedded.{EmbeddedDatabaseBuilder, EmbeddedDatabaseType}
import org.springframework.jdbc.datasource.init.{DataSourceInitializer, DatabasePopulator, ResourceDatabasePopulator}
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.orm.jpa.{JpaTransactionManager, LocalContainerEntityManagerFactoryBean}
import org.springframework.transaction.PlatformTransactionManager

/**
  * Created by Dawid on 03.07.2016.
  */
// children to be annotated by @DatabaseConfiguration
class CommonMockDbConfig {

  @Value("classpath:db_create.sql")
  private val h2DbCreateScript: Resource = null

  @Value("classpath:db_data_init.sql")
  private val h2DbDataInitScript: Resource = null

  private val dbContextPath = "/db/*"

  @Bean
  def dataSource(env: Environment): DataSource = {
    new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.H2)
      .addScript("db_create.sql")
      .addScript("db_data_init.sql")
      .build
  }

  @Bean
  def h2servletRegistration(): ServletRegistrationBean = {
    val registrationBean = new ServletRegistrationBean(new WebServlet)
    registrationBean.addUrlMappings(dbContextPath)
    registrationBean
  }

  @Bean
  @Inject
  def dataSourceInitializer(dataSource: DataSource): DataSourceInitializer = {
    val initializer = new DataSourceInitializer
    initializer.setDataSource(dataSource)
    initializer.setDatabasePopulator(databasePopulator)
    initializer
  }

  private def databasePopulator(): DatabasePopulator = {
    val populator = new ResourceDatabasePopulator
    populator.addScript(h2DbCreateScript)
    populator.addScript(h2DbDataInitScript)
    populator
  }


  @Bean
  def transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager = {
    val transactionManager = new JpaTransactionManager
    transactionManager.setEntityManagerFactory(entityManagerFactory)
    transactionManager
  }

  @Bean
  def entityManagerFactory(env: Environment): LocalContainerEntityManagerFactoryBean = {
    val vendorAdapter = new HibernateJpaVendorAdapter
    vendorAdapter.setGenerateDdl(true)
    vendorAdapter.setShowSql(true)

    val factory = new LocalContainerEntityManagerFactoryBean()
    factory.setJpaVendorAdapter(vendorAdapter)
    factory.setPackagesToScan("dawid.kotarba.users")
    factory.setDataSource(dataSource(env))

    factory.setJpaProperties(jpaProperties)
    factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver)
    factory
  }

  private def jpaProperties(): Properties = {
    val props = new Properties
    props.put("hibernate.show_sql", "true")
    props.put("hibernate.format_sql", "true")
    props
  }
}

