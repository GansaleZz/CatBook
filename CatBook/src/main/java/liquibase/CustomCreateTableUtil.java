package liquibase;

import liquibase.change.ColumnConfig;
import liquibase.database.Database;
import liquibase.datatype.DataTypeFactory;
import liquibase.statement.DatabaseFunction;
import liquibase.statement.ForeignKeyConstraint;
import liquibase.statement.core.CreateTableStatement;

public class CustomCreateTableUtil {

    private static CustomCreateTableUtil INSTANCE = null;

    private CustomCreateTableUtil() {}

    public static CustomCreateTableUtil getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomCreateTableUtil();
        }

        return INSTANCE;
    }

    public CreateTableStatement addSpecificColumnsForNewTable(CreateTableStatement createTableStatement, Database database) {
        //Add CreatedDate column.
        addActionDateColumn(createTableStatement, database,
                "CreatedDate", "datetime", "Define the date of record creating.");
        //Add ModifiedDate column.
        addActionDateColumn(createTableStatement, database,
                "ModifiedDate", "datetime", "Define the date of the last updating of record.");
        //Add CreatedByID column.
        addActionByColumn(createTableStatement, database,
                "fk_" + createTableStatement.getTableName() + "_1", "CB_User(ID)", true,
                "CreatedByID", "bigint", "User who created the record. FK to CB_User table.");
        //Add ModifiedByID column.
        addActionByColumn(createTableStatement, database,
                "fk_" + createTableStatement.getTableName() + "_2", "CB_User(ID)", true,
                "ModifiedByID", "bigint", "Last user which updated the record. FK to CB_User table.");
        //Add ActiveFlag column.
        addActiveFlagColumn(createTableStatement, database);

        return createTableStatement;
    }

    private void addActionDateColumn(CreateTableStatement createTableStatement, Database database,
                                     String columnName, String columnType, String columnRemarks) {
        ColumnConfig actionDateColumn = new ColumnConfig();
        actionDateColumn.setName(columnName);
        actionDateColumn.setType(columnType);
        actionDateColumn.setRemarks(columnRemarks);
        actionDateColumn.setDefaultValueComputed(new DatabaseFunction("now()"));

        createTableStatement.addColumn(actionDateColumn.getName(),
                DataTypeFactory.getInstance().fromDescription(actionDateColumn.getType(), database),
                actionDateColumn.getDefaultValueConstraintName(),
                actionDateColumn.getDefaultValueComputed(),
                actionDateColumn.getRemarks());
    }

    private void addActionByColumn(CreateTableStatement createTableStatement, Database database,
                                   String fkName, String fkReference, boolean fkValidate,
                                   String columnName, String columnType, String columnRemarks) {
        ColumnConfig actionByColumn = new ColumnConfig();
        ForeignKeyConstraint foreignKeyConstraint = new ForeignKeyConstraint(
                fkName, fkReference, fkValidate);
        foreignKeyConstraint.setColumn(columnName);
        actionByColumn.setName(columnName);
        actionByColumn.setType(columnType);
        actionByColumn.setRemarks(columnRemarks);
        actionByColumn.setDefaultValueNumeric(-1);

        createTableStatement.addColumn(actionByColumn.getName(),
                DataTypeFactory.getInstance().fromDescription(actionByColumn.getType(), database),
                actionByColumn.getDefaultValueConstraintName(),
                actionByColumn.getDefaultValueNumeric(),
                actionByColumn.getRemarks());
        createTableStatement.getForeignKeyConstraints().add(foreignKeyConstraint);
    }

    private void addActiveFlagColumn(CreateTableStatement createTableStatement, Database database) {
        ColumnConfig activeFlagColumn = new ColumnConfig();
        activeFlagColumn.setName("ActiveFlag");
        activeFlagColumn.setType("varchar(1)");
        activeFlagColumn.setDefaultValue("Y");
        activeFlagColumn.setRemarks("Define if record is active.");
        createTableStatement.addColumn(activeFlagColumn.getName(),
                DataTypeFactory.getInstance().fromDescription(activeFlagColumn.getType(), database),
                activeFlagColumn.getDefaultValueConstraintName(),
                activeFlagColumn.getDefaultValue(),
                activeFlagColumn.getRemarks());
    }

}
