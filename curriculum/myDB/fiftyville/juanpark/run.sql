SELECT name
    FROM people
    JOIN bank_accounts ON bank_accounts.person_id = people.id
    WHERE license_plate IN (
        SELECT license_plate
        FROM bakery_security_logs
        WHERE year = 2023 AND month = 7 AND day = 28 AND hour = 10 AND minute > 15 AND minute < 30
        )
    AND people.id IN (
        SELECT person_id
        FROM bank_accounts
        WHERE account_number IN (
            SELECT account_number
            FROM atm_transactions
            WHERE atm_location = 'Leggett Street' AND year = 2023 AND month = 7 AND day = 28 AND transaction_type = 'withdraw'
            )
        )
    AND people.phone_number IN (
        SELECT caller
        FROM phone_calls
        WHERE year = 2023 AND month = 7 AND day = 28 AND duration < 60
        )
    AND passport_number IN (
        SELECT passport_number
        FROM passengers
        WHERE flight_id IN (
            SELECT id
            FROM flights
            WHERE origin_airport_id IN (
                SELECT id
                FROM airports
                WHERE abbreviation = 'CSF'
            )
            AND year = 2023 AND month = 7 AND day = 29 ORDER BY hour LIMIT 1
        )
    );
