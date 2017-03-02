<?php
    $db = file_get_contents("postback.csv");
    $array = explode(",", $db);
    array_push($array, $_GET["postback"]);
    $db_write = fopen("postback.csv", "w");
    fwrite($db_write, implode(",", $array));
    fclose($db_write);
?>
