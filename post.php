<?php
$dump_post = print_r($_POST, TRUE);
$file = fopen("postback.txt", "a");
fwrite($file, $dump_post);
fclose($file);
?>
