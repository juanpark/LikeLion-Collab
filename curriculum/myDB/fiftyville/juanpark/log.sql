-- Keep a log of any SQL queries you execute as you solve the mystery.

-- What tables are in the database?
.table

-- What's the overall schema and how do the tables relate to each other?
.schema

-- Peeking in to the people table
SELECT * FROM people;

-- How many people are in the people table? 200
SELECT COUNT(*) FROM people;

-- Let's study the crime_scene_reports table schema
.schema crime_scene_reports

-- Let's see all crimes that happned on Humphrey Street
SELECT * FROM crime_scene_reports
   ...> WHERE street = 'Humphrey Street';
-- Theft of CS50 duck: id 295
-- Date: 2023/7/28
-- Time: Theft took place at 10:15 a.m.
-- Location: Humphrey Street Bakery
-- Three witnesses interviewed who were present: all mention bakery > check interview transcrips
-- Others: 16:36 littering with know witness the same day. 23/7/30 17:49 littering with two witnesses (possible interview?)

-- Let's check interviews
.schema interviews

SELECT * FROM interviews
   ...> WHERE year = 2023 AND month = 7 AND day = 28;
-- | 161 | Ruth    | 2023 | 7     | 28  | Sometime within ten minutes of the theft, I saw the thief get into a car in the bakery parking lot and drive away. If you have security footage from the bakery parking lot, you might want to look for cars that left the parking lot in that time frame.                                                          |
-- | 162 | Eugene  | 2023 | 7     | 28  | I don't know the thief's name, but it was someone I recognized. Earlier this morning, before I arrived at Emma's bakery, I was walking by the ATM on Leggett Street and saw the thief there withdrawing some money.                                                                                                 |
-- | 163 | Raymond | 2023 | 7     | 28  | As the thief was leaving the bakery, they called someone who talked to them for less than a minute. In the call, I heard the thief say that they were planning to take the earliest flight out of Fiftyville tomorrow. The thief then asked the person on the other end of the phone to purchase the flight ticket. |
-- | 191 | Lily    | 2023 | 7     | 28  | Our neighboring courthouse has a very annoying rooster that crows loudly at 6am every day. My sons Robert and Patrick took the rooster to a city far, far away, so it may never bother us again. My sons have successfully arrived in Paris.

SELECT * FROM interviews
   ...> WHERE year = 2023 AND month = 7 AND day = 30;
-- no interviews, was wondering about the littering

-- Checking security footage for car activities (license_plate) on 7/28
SELECT * FROM bakery_security_logs WHERE year = 2023 AND month = 7 AND day = 28 AND hour = 10 ;

SELECT name
   ...> FROM people
   ...> WHERE license_plate IN (
   ...>     SELECT license_plate
   ...>     FROM bakery_security_logs
   ...>     WHERE year = 2023 AND month = 7 AND day = 28 AND hour = 10
   ...> );
+---------+
|  name   |
+---------+
| Vanessa |
| Barry   |
| Brandon |
| Iman    |
| Sofia   |
| Taylor  |
| Luca    |
| Diana   |
| Kelsey  |
| Denise  |
| Thomas  |
| Bruce   |
| Sophia  |
| Jeremy  |
+---------+


SELECT * FROM atm_transactions WHERE atm_location = 'Leggett Street' AND year = 2023 AND month = 07 AND day = 28 AND transaction_type = 'withdraw';
+-----+----------------+------+-------+-----+----------------+------------------+--------+
| id  | account_number | year | month | day |  atm_location  | transaction_type | amount |
+-----+----------------+------+-------+-----+----------------+------------------+--------+
| 246 | 28500762       | 2023 | 7     | 28  | Leggett Street | withdraw         | 48     |
| 264 | 28296815       | 2023 | 7     | 28  | Leggett Street | withdraw         | 20     |
| 266 | 76054385       | 2023 | 7     | 28  | Leggett Street | withdraw         | 60     |
| 267 | 49610011       | 2023 | 7     | 28  | Leggett Street | withdraw         | 50     |
| 269 | 16153065       | 2023 | 7     | 28  | Leggett Street | withdraw         | 80     |
| 288 | 25506511       | 2023 | 7     | 28  | Leggett Street | withdraw         | 20     |
| 313 | 81061156       | 2023 | 7     | 28  | Leggett Street | withdraw         | 30     |
| 336 | 26013199       | 2023 | 7     | 28  | Leggett Street | withdraw         | 35     |
+-----+----------------+------+-------+-----+----------------+------------------+--------+


-- combine suspects from license_plate and suspects from ATM retrieval
SELECT name
    FROM people
    JOIN bank_accounts ON bank_accounts.person_id = people.id
    WHERE license_plate IN (
        SELECT license_plate
        FROM bakery_security_logs
        WHERE year = 2023 AND month = 7 AND day = 28 AND hour = 10
        )
    AND people.id IN (
        SELECT person_id
        FROM bank_accounts
        WHERE account_number IN (
            SELECT account_number
            FROM atm_transactions
            WHERE atm_location = 'Leggett Street' AND year = 2023 AND month = 7 AND day = 28 AND transaction_type = 'withdraw'
            )
        );
+--------+
|  name  |
+--------+
| Bruce  |
| Diana  |
| Iman   |
| Luca   |
| Taylor |
+--------+


-- Added another condition of someone calling on 7/28 less than 60 seconds
SELECT name
    FROM people
    JOIN bank_accounts ON bank_accounts.person_id = people.id
    WHERE license_plate IN (
        SELECT license_plate
        FROM bakery_security_logs
        WHERE year = 2023 AND month = 7 AND day = 28 AND hour = 10
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
        );
+--------+
|  name  |
+--------+
| Bruce  |
| Diana  |
| Taylor |
+--------+


-- Added condtion of airport leaving Fiftyville, on 7/29, the earliest flight:
SELECT name
    FROM people
    JOIN bank_accounts ON bank_accounts.person_id = people.id
    WHERE license_plate IN (
        SELECT license_plate
        FROM bakery_security_logs
        WHERE year = 2023 AND month = 7 AND day = 28 AND hour = 10
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
+--------+
|  name  |
+--------+
| Bruce  |
| Taylor |
+--------+

-- further refining the bakery_sercurity_logs based on witness accounts Bruce seems to be the most likely suspect!
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
+-------+
| name  |
+-------+
| Bruce |
+-------+

-- Bruce's accomplice is Robin according to the the phone call's receiver on the call made 7/28 for less than 60 seconds
SELECT name
FROM people
WHERE phone_number IN (
    SELECT receiver
    FROM phone_calls
    WHERE caller IN (
        SELECT phone_number
        FROM people
        WHERE name = 'Bruce'
    )
    AND year = 2023 AND month = 7 AND day = 28 AND duration < 60
);
+-------+
| name  |
+-------+
| Robin |
+-------+


-- the escape flight seems to be the NY
SELECT city
FROM airports
WHERE id IN (
    SELECT destination_airport_id
    FROM flights
    WHERE origin_airport_id = (
        SELECT id
        FROM airports
        WHERE city = 'Fiftyville'
    )
    AND year = 2023 AND month = 7 AND day = 29 ORDER BY hour LIMIT 1
);
+---------------+
|     city      |
+---------------+
| New York City |
+---------------+

-- Let's confirm that Bruce and Robin are indeed passengers to that flight to confirm

sqlite> SELECT id FROM flights WHERE origin_airport_id = 8 AND destination_airport_id = 4 AND year = 2023 AND month = 7 AND day = 29;
+----+
| id |
+----+
| 36 |
+----+
sqlite> SELECT * FROM flights WHERE id = 36;
+----+-------------------+------------------------+------+-------+-----+------+--------+
| id | origin_airport_id | destination_airport_id | year | month | day | hour | minute |
+----+-------------------+------------------------+------+-------+-----+------+--------+
| 36 | 8                 | 4                      | 2023 | 7     | 29  | 8    | 20     |
+----+-------------------+------------------------+------+-------+-----+------+--------+

sqlite> SELECT * FROM passengers WHERE flight_id = 36;
+-----------+-----------------+------+
| flight_id | passport_number | seat |
+-----------+-----------------+------+
| 36        | 7214083635      | 2A   |
| 36        | 1695452385      | 3B   |
| 36        | 5773159633      | 4A   |
| 36        | 1540955065      | 5C   |
| 36        | 8294398571      | 6C   |
| 36        | 1988161715      | 6D   |
| 36        | 9878712108      | 7A   |
| 36        | 8496433585      | 7B   |
+-----------+-----------------+------+
sqlite> SELECT name FROM people WHERE passport_number IN (
   ...> SELECT passport_number FROM passengers WHERE flight_id = 36
   ...> );
+--------+
|  name  |
+--------+
| Kenny  |
| Sofia  |
| Taylor |
| Luca   |
| Kelsey |
| Edward |
| Bruce  |
| Doris  |
+--------+
-- I see Bruce, but I don't see Robin. Did I make a mistake regarding the accomplice?
SELECT *
FROM phone_calls
WHERE caller = (
    SELECT phone_number
    FROM people
    WHERE name = 'Bruce'
    );
+-----+----------------+----------------+------+-------+-----+----------+
| id  |     caller     |    receiver    | year | month | day | duration |
+-----+----------------+----------------+------+-------+-----+----------+
| 9   | (367) 555-5533 | (113) 555-7544 | 2023 | 7     | 25  | 469      |
| 104 | (367) 555-5533 | (238) 555-5554 | 2023 | 7     | 26  | 84       |
| 122 | (367) 555-5533 | (660) 555-3095 | 2023 | 7     | 26  | 399      |
| 133 | (367) 555-5533 | (286) 555-0131 | 2023 | 7     | 26  | 444      |
| 233 | (367) 555-5533 | (375) 555-8161 | 2023 | 7     | 28  | 45       |
| 236 | (367) 555-5533 | (344) 555-9601 | 2023 | 7     | 28  | 120      |
| 245 | (367) 555-5533 | (022) 555-4052 | 2023 | 7     | 28  | 241      |
| 285 | (367) 555-5533 | (704) 555-5790 | 2023 | 7     | 28  | 75       |
| 395 | (367) 555-5533 | (455) 555-5315 | 2023 | 7     | 30  | 31       |
| 418 | (367) 555-5533 | (841) 555-3728 | 2023 | 7     | 30  | 511      |
| 488 | (367) 555-5533 | (696) 555-9195 | 2023 | 7     | 31  | 261      |
+-----+----------------+----------------+------+-------+-----+----------+

SELECT name FROM people WHERE phone_number = '(375) 555-8161';
+-------+
| name  |
+-------+
| Robin |
+-------+
-- then did Robin not join Bruce in the flight?

qlite> SELECT * FROM people WHERE name = 'Robin';
+--------+-------+----------------+-----------------+---------------+
|   id   | name  |  phone_number  | passport_number | license_plate |
+--------+-------+----------------+-----------------+---------------+
| 864400 | Robin | (375) 555-8161 | NULL            | 4V16VO0       |
+--------+-------+----------------+-----------------+---------------+
-- Ah hah! Robin has no passport_number!

-- Then let's check the flight again (flight id = 36)
