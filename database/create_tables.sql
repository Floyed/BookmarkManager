SET search_path = "bookmarkmanagement";


insert into folder (id,status,name,path)
values(1,'ACTIVE','root','/');

insert into bookmark (id,status,path,url,folder_id)
values(1,'ACTIVE','/','/',1)

