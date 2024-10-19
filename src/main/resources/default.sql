INSERT INTO users(created_at, deleted, created_by,
                  email, fullname, premium, notifications_enabled,
                  password,
                  phone, role, two_factor_enabled, username)
VALUES (CURRENT_TIMESTAMP, false, 1,
        'nigga@gmail.com', 'Niggayev Nigga', false, false,
        '$2a$10$iUk6s8/YZnnkCpvMNmCuguG5EgB/VM455hL291FUJLfdITuZOkEee',
        '998336831054', 'USER', false, 'nigga');


truncate fee CASCADE;
truncate transaction CASCADE;
truncate otp CASCADE;
truncate wallet_history CASCADE;

