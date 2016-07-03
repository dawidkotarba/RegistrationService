-- USER TABLE
INSERT INTO public.users (username, password, enabled, role) VALUES
  ('admin', 'admin', TRUE, 'ROLE_ADMIN'),
  ('user', 'user', TRUE, 'ROLE_USER');