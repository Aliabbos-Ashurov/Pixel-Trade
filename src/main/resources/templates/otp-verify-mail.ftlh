<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .email-container {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: left;
        }

        .header {
            background-color: #1a1a1a;
            text-align: center;
            padding: 20px;
        }

        .header img {
            width: 100%;
            height: auto;
        }

        .content {
            padding: 20px;
        }

        .content h1 {
            color: #333333;
            font-size: 24px;
            margin-bottom: 20px;
        }

        .content p {
            font-size: 16px;
            color: #555555;
            margin-bottom: 10px;
            line-height: 1.5;
        }

        .verify-button {
            display: inline-block;
            background-color: #e33e2e;
            color: white;
            text-decoration: none;
            padding: 15px 30px;
            font-size: 18px;
            font-weight: bold;
            border-radius: 5px;
            margin: 20px 0;
        }

        .footer {
            margin-top: 30px;
            font-size: 12px;
            color: #999999;
            text-align: center;
        }

        .footer a {
            color: #e33e2e;
            text-decoration: none;
        }
    </style>
    <title>Verify Your Email</title>
</head>
<body>

<div class="email-container">
    <div class="header">
        <img src="https://your-meal.s3.amazonaws.com/public/brandlogo2.png" alt="Brand Logo">
    </div>

    <div class="content">
        <h1>Verify Your Email</h1>
        <p>Thank you for registering with Pixel Trade! Please verify your email address to start using your account.</p>
        <p>Click the button below to verify your email:</p>
        <a href="http://localhost:8080/api/v1/otp/verify-mail/${code}" class="verify-button">Verify Email</a>
    </div>

    <div class="footer">
        <p>If you did not sign up for this service, please ignore this email.</p>
        <p>Pixel Trade Team<br>This is an automated message, please do not reply.</p>
    </div>
</div>

</body>
</html>
