<?php
if(isset($_COOKIE["user_name"])){
//echo $_COOKIE["user_name"];
var_dump($_COOKIE);
echo $_COOKIE["uid"];
}else{
    setcookie('user_name','Tiago', time() + 3600);
    setcookie('uid','123');
    
}
