package com.eddy.cribz.bookingSystem.core.utils;

import java.sql.Types;

import org.hibernate.dialect.SQLServerDialect;

public class CustomSQLServerDialect extends SQLServerDialect {

	public CustomSQLServerDialect() {
		super();

		registerColumnType(Types.BIGINT, "bigint");
	}
}