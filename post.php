<?php
$dump_post = print_r($_GET, TRUE);
$file = fopen("postback.txt", "a");
fwrite($file, $dump_post);
fclose($file);
?>
