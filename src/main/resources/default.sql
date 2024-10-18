INSERT INTO users(created_at, deleted, created_by,
                  email, fullname, premium, notifications_enabled,
                  password,
                  phone, role, two_factor_enabled, username)
VALUES (CURRENT_TIMESTAMP, false, 1,
        'nigga@gmail.com', 'Niggayev Nigga', false, false,
        '$2a$10$iUk6s8/YZnnkCpvMNmCuguG5EgB/VM455hL291FUJLfdITuZOkEee',
        '998336831054', 'USER', false, 'nigga');


INSERT INTO public.crypto (name, symbol, image_url, fee_percentage, created_by)
VALUES ('Bitcoin', 'BTC', 'https://pixel-trade.s3.amazonaws.com/crypto/bitcoin-btc-logo.png', 0.30, -1),
       ('USD dollar', 'USDT', 'https://pixel-trade.s3.amazonaws.com/crypto/dollar_logo.png', 0.10, -1),
       ('Ethereum', 'ETH', 'https://pixel-trade.s3.amazonaws.com/crypto/ethereum-eth-logo.png', 0.30, -1),
       ('Ton', 'TON', 'https://pixel-trade.s3.amazonaws.com/crypto/toncoin-ton-logo.png', 0.30, -1),
       ('Dogs', 'DOGS', 'https://pixel-trade.s3.amazonaws.com/crypto/dogs-dogs-logo.png', 0.25, -1),
       ('Solana', 'SOL', 'https://pixel-trade.s3.amazonaws.com/crypto/solana-sol-logo.png', 0.20, -1),
       ('Cardano', 'ADA', 'https://pixel-trade.s3.amazonaws.com/crypto/cardano-ada-logo.png', 0.20, -1),
       ('Binance Coin', 'BNB', 'https://pixel-trade.s3.amazonaws.com/crypto/bnb-bnb-logo.png', 0.20, -1),
       ('Dogecoin', 'DOGE', 'https://pixel-trade.s3.amazonaws.com/crypto/dogecoin-doge-logo.png', 0.30, -1);


truncate fee CASCADE;
truncate  transaction CASCADE;
truncate  otp CASCADE;
truncate  wallet_history CASCADE;

