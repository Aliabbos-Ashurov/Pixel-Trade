<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff;
            margin: 0;
            padding: 0;
        }

        .email-container {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            background-color: #000000;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: left;
        }

        .header {
            background-color: #ffffff;
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
            color: #ffffff;
            font-size: 24px;
            margin-bottom: 20px;
        }

        .content p {
            font-size: 16px;
            color: #efefef;
            margin-bottom: 10px;
            line-height: 1.5;
        }

        .button-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 20px;
        }

        .button-container a {
            display: inline-block;
            padding: 10px 20px;
            width: 48%;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
        }

        .verify-button {
            background-color: #e33e2e;
            color: #ffffff;
            border-radius: 5px 0 0 5px;
        }

        .not-me-button {
            background-color: #666666;
            color: #ffffff;
            border-radius: 0 5px 5px 0;
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

        @media (max-width: 600px) {
            .button-container a {
                width: 100%;
                margin-bottom: 10px;
            }

            .button-container a:last-child {
                margin-bottom: 0;
            }

            .button-container {
                flex-direction: column;
            }
        }
    </style>
    <title>Backup Mail Verification</title>
    <script>
        function disableButton() {
            const button = document.getElementById('verifyButton');
            button.classList.add('button-disabled');
            button.innerText = 'Verification Sent!';
            button.href = '#';
        }
    </script>
</head>
<body>

<div class="email-container">
    <div class="header">
        <img src="https://your-meal.s3.amazonaws.com/public/brandlogo2.png" alt="Brand Logo">
    </div>

    <div class="content">
        <h1>Verify Your Backup Email</h1>
        <p>To verify your backup email address, please click the button below:</p>
        <div class="button-container">
            <a href="http://${host}:${port}/api/v1/mail/verify-backup-mail?id=${id}&mail=${mail}"
               class="verify-button"
               id="verifyButton" onclick="disableButton()">Verify Mail</a>
            <a href="#" class="not-me-button">It's not me!</a>
        </div>
        <p style="margin-top: 20px;">If you do not receive the verification email shortly, please check your spam or
            junk folder. If you continue to experience issues, you may try verifying your backup email again, but only
            one attempt is allowed at this time. After clicking the button, it will change to indicate that the
            verification request has been sent.</p>
    </div>

    <div class="footer">
        <p>If you don't recognize this activity, please contact our customer support immediately at <a
                    href="https://www.pixeltrade.com/en/support">https://www.pixeltrade.com/en/support</a>.</p>
        <p>Pixel Trade Team<br>This is an automated message, please do not reply.</p>
    </div>
</div>

</body>
</html>
