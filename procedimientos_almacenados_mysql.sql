--
DELIMITER //
CREATE PROCEDURE sp_verifica_rfc(IN _rfc varchar(10))
BEGIN
    IF(fn_cumple(_rfc)) then 
        call sp_obtener_cliente(_rfc);
    ELSE
        call sp_error(1);
    END IF;
END //


--Verifica mediante expreciones regulares que cumpla con un RFC
DELIMITER //
CREATE FUNCTION fn_cumple ( _rfc varchar(10) )
RETURNS BOOLEAN
BEGIN
   DECLARE cumple BOOLEAN;
   IF _rfc REGEXP '^[A-Za-z][A-Za-z][A-Za-z][A-Za-z][0-9][0-9][0-9][0-9][0-9][0-9]$' THEN
      SET cumple = true;
   ELSE
      SET cumple = false;
   END IF;
   RETURN cumple;
END; //


--Obtiene cliente mediante su rfc
DELIMITER //
CREATE PROCEDURE sp_obtener_cliente(IN _rfc varchar(10))
BEGIN		
    select * from clientes where rfc=_rfc;
END //


--Manejo de errores
DELIMITER //
CREATE PROCEDURE sp_error(IN _error INT)
BEGIN		
    CASE _error
        WHEN 1 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El RFC no esta definido correctamente';
        WHEN 2 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = '';
    END CASE;
END //


--Trigger para convertir en mayusculas el RFC
DELIMITER //
CREATE TRIGGER tr_ins_mayusculas BEFORE INSERT ON clientes
FOR EACH ROW
BEGIN
    set new.rfc = upper(new.rfc);
END //
