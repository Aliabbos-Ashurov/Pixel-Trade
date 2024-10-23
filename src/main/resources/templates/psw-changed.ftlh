<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #ffffff;
            margin: 0;
            padding: 0;
            line-height: 1.6;
        }

        .email-container {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            background-color: #000000;
            border-radius: 8px;
            box-shadow: 0 2px 15px rgba(0, 0, 0, 0.1); /* Softer shadow */
            overflow: hidden; /* Ensure no overflow */
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
            padding: 30px;
            color: #343a40;
        }

        .content h1 {
            color: #ffffff;
            font-size: 28px;
            margin-bottom: 15px;
        }

        .content p {
            font-size: 16px;
            color: #ffffff;
            margin-bottom: 15px;
        }

        .confirmation-message {
            font-size: 22px;
            font-weight: bold;
            color: #28a745;
            background-color: #d4edda;
            padding: 15px;
            border-left: 5px solid #28a745;
            margin: 20px 0;
        }

        .footer {
            padding: 20px;
            font-size: 14px;
            color: #ffffff;
            text-align: center;
            background-color: #f8f9fa;
        }

        .footer a {
            color: #999999;
            text-decoration: none;
        }

        .footer a:hover {
            text-decoration: underline;
        }
    </style>
    <title>Password Change Confirmation</title>
</head>
<body>

<div class="email-container">
    <div class="header">
        <img src="https://your-meal.s3.amazonaws.com/public/brandlogo2.png" alt="Brand Logo">
    </div>

    <div class="content">
        <h1>Password Changed Successfully</h1>
        <p>Dear User,</p>
        <p>Your password has been changed successfully. You can now log in with your new password.</p>
        <div class="confirmation-message">Your password has been changed successfully!</div>
        <p>If you did not make this change, please contact our support team immediately.</p>
    </div>

    <div class="footer">
        <p>For any assistance, reach out to our customer support at <a
                    href="https://www.pixeltrade.com/en/support">https://www.pixeltrade.com/en/support</a>.</p>
        <p>Pixel Trade Team<br>This is an automated message, please do not reply.</p>
    </div>
</div>

</body>
</html>
