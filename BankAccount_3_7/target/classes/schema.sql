create table saving_account(
  account_number varchar,
  balance float ,
  open_time_stamp float
);
create table transactions(
  account_number varchar,
  timestamp bigint,
  amount int,
  description varchar
);