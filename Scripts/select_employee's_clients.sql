select *
from client
where client_id in (select client_id from employee_client where employee_id = 1)