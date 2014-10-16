package com.eddy.cribz.bookingSystem.core.utils;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQLDialect;

public class CustomPostgreSQLDialect extends PostgreSQLDialect {

	public CustomPostgreSQLDialect() {
		super();

		registerColumnType(Types.BLOB, "bytea");
	}
}