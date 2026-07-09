DECLARE
    CURSOR c_customers IS
        SELECT customer_id, dob FROM customers;
    v_age NUMBER;
BEGIN
    FOR r_cust IN c_customers LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, r_cust.dob) / 12);
        IF v_age > 60 THEN
            UPDATE loans
            SET interest_rate = interest_rate - 1
            WHERE customer_id = r_cust.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/
