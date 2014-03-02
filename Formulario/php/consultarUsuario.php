<?php
include('functions.php'); 
if ($resultset = getSQLResultSet("SELECT *
FROM  `funcionarios` ")) {
		$table=array();
    	while ($row = $resultset->fetch_assoc()) {
    			$fila= array();

    			foreach ($row as $key => $value) {
    				if(!$value){
    					$fila[$key]="";
    				}else{
    					$fila[$key]=$value;
    				}
    			}

    	$table[]=$fila;
    	
    	}
    	echo json_encode($table);
   }
   
?>
