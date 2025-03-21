SELECT *
FROM phone_calls
WHERE caller = (
    SELECT phone_number
    FROM people
    WHERE name = 'Bruce'
    );
