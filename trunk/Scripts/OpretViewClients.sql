create OR replace view [clients] AS
SELECT employee_client_id, client_id
FROM employee_client
WHERE employee_id = 1