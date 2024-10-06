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

        .activation-code {
            font-size: 32px;
            font-weight: bold;
            color: #e33e2e;
            margin: 20px 0;
        }

        .security-tips {
            margin-top: 20px;
        }

        .security-tips p {
            font-size: 14px;
            color: #777777;
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
    <title>Confirm Your Registration</title>
</head>
<body>

<div class="email-container">
    <div class="header">
        <img src="https://your-meal.s3.amazonaws.com/public/brandlogo2.png" alt="Brand Logo">
    </div>

    <div class="content">
        <h1>Confirm Your Registration</h1>
        <p>Welcome to Pixel Trade! Here is your account activation code:</p>
        <div class="activation-code">${code}</div>
        <div class="security-tips">
            <p><strong>Security Tips:</strong></p>
            <p>* Never give your password to anyone.</p>
            <p>* Never call any phone number for someone claiming to be Pixel Trade Support.</p>
            <p>* Never send any money to anyone claiming to be a member of Pixel Trade team.</p>
            <p>* Enable Google Two-Factor Authentication.</p>
            <p>* Bookmark www.pixeltrade.com and use https://www.pixeltrade.com/official-verification to verify the
                domain you're visiting.</p>
        </div>
    </div>

    <div class="footer">
        <p>If you don't recognize this activity, please contact our customer support immediately at <a
                    href="https://www.pixeltrade.com/en/support">https://www.pixeltrade.com/en/support</a>.</p>
        <p>Pixel Trade Team<br>This is an automated message, please do not reply.</p>
    </div>
</div>

</body>
</html>
