// Description: Java 11 Oracle Jdbc DbIO implementation for Table.

/*
 *	server.markhome.msscf.CFBam
 *
 *	Copyright (c) 2020-2025 Mark Stephen Sobkow
 *	
 *
 *	Manufactured by MSS Code Factory 2.13
 */

package server.markhome.msscf.cfbam.CFBamOracle;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import oracle.jdbc.OracleTypes;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cflib.CFLib.*;
import server.markhome.msscf.cfsec.CFSec.*;
import server.markhome.msscf.cfint.CFInt.*;
import server.markhome.msscf.cfbam.CFBam.*;
import server.markhome.msscf.cfsec.CFSecObj.*;
import server.markhome.msscf.cfint.CFIntObj.*;
import server.markhome.msscf.cfbam.CFBamObj.*;

/*
 *	CFBamOracleTableTable Oracle Jdbc DbIO implementation
 *	for Table.
 */
public class CFBamOracleTableTable
	implements ICFBamTableTable
{
	private CFBamOracleSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByTenantIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByTenantIdx = null;
	protected PreparedStatement stmtReadBuffBySchemaDefIdx = null;
	protected PreparedStatement stmtReadBuffByDefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtReadBuffBySchemaCdIdx = null;
	protected PreparedStatement stmtReadBuffByPrimaryIndexIdx = null;
	protected PreparedStatement stmtReadBuffByLookupIndexIdx = null;
	protected PreparedStatement stmtReadBuffByAltIndexIdx = null;
	protected PreparedStatement stmtReadBuffByQualTableIdx = null;
	protected PreparedStatement stmtDeleteBySchemaDefIdx = null;
	protected PreparedStatement stmtDeleteByDefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtDeleteBySchemaCdIdx = null;
	protected PreparedStatement stmtDeleteByPrimaryIndexIdx = null;
	protected PreparedStatement stmtDeleteByLookupIndexIdx = null;
	protected PreparedStatement stmtDeleteByAltIndexIdx = null;
	protected PreparedStatement stmtDeleteByQualTableIdx = null;

	public CFBamOracleTableTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createTable( CFSecAuthorization Authorization,
		CFBamTableBuff Buff )
	{
		final String S_ProcName = "createTable";
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long SchemaDefId = Buff.getRequiredSchemaDefId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			String Name = Buff.getRequiredName();
			String DbName = Buff.getOptionalDbName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			boolean PageData = Buff.getRequiredPageData();
			Long PrimaryIndexTenantId = Buff.getOptionalPrimaryIndexTenantId();
			Long PrimaryIndexId = Buff.getOptionalPrimaryIndexId();
			String TableClassCode = Buff.getRequiredTableClassCode();
			Long LookupIndexTenantId = Buff.getOptionalLookupIndexTenantId();
			Long LookupIndexId = Buff.getOptionalLookupIndexId();
			Long AltIndexTenantId = Buff.getOptionalAltIndexTenantId();
			Long AltIndexId = Buff.getOptionalAltIndexId();
			Long QualifyingTenantId = Buff.getOptionalQualifyingTenantId();
			Long QualifyingTableId = Buff.getOptionalQualifyingTableId();
			boolean IsInstantiable = Buff.getRequiredIsInstantiable();
			boolean HasHistory = Buff.getRequiredHasHistory();
			boolean HasAuditColumns = Buff.getRequiredHasAuditColumns();
			boolean IsMutable = Buff.getRequiredIsMutable();
			boolean IsServerOnly = Buff.getRequiredIsServerOnly();
			ICFBamSchema.LoaderBehaviourEnum LoaderBehaviour = Buff.getRequiredLoaderBehaviour();
			ICFBamSchema.SecScopeEnum SecScope = Buff.getRequiredSecScope();
			String JObjMembers = Buff.getOptionalJObjMembers();
			String JObjInterface = Buff.getOptionalJObjInterface();
			String JObjImport = Buff.getOptionalJObjImport();
			String JObjImplementation = Buff.getOptionalJObjImplementation();
			String JEditObjMembers = Buff.getOptionalJEditObjMembers();
			String JEditObjInterface = Buff.getOptionalJEditObjInterface();
			String JEditObjImport = Buff.getOptionalJEditObjImport();
			String JEditObjImplementation = Buff.getOptionalJEditObjImplementation();
			String JTableImport = Buff.getOptionalJTableImport();
			String JTableMembers = Buff.getOptionalJTableMembers();
			String JTableInterface = Buff.getOptionalJTableInterface();
			String JTableImplementation = Buff.getOptionalJTableImplementation();
			String JTableObjImport = Buff.getOptionalJTableObjImport();
			String JTableObjMembers = Buff.getOptionalJTableObjMembers();
			String JTableObjInterface = Buff.getOptionalJTableObjInterface();
			String JTableObjImplementation = Buff.getOptionalJTableObjImplementation();
			String JDb2LUWTableImport = Buff.getOptionalJDb2LUWTableImport();
			String JDb2LUWTableMembers = Buff.getOptionalJDb2LUWTableMembers();
			String JDb2LUWTableImplementation = Buff.getOptionalJDb2LUWTableImplementation();
			String JMSSqlTableImport = Buff.getOptionalJMSSqlTableImport();
			String JMSSqlTableMembers = Buff.getOptionalJMSSqlTableMembers();
			String JMSSqlTableImplementation = Buff.getOptionalJMSSqlTableImplementation();
			String JMySqlTableImport = Buff.getOptionalJMySqlTableImport();
			String JMySqlTableMembers = Buff.getOptionalJMySqlTableMembers();
			String JMySqlTableImplementation = Buff.getOptionalJMySqlTableImplementation();
			String JOracleTableImport = Buff.getOptionalJOracleTableImport();
			String JOracleTableMembers = Buff.getOptionalJOracleTableMembers();
			String JOracleTableImplementation = Buff.getOptionalJOracleTableImplementation();
			String JPgSqlTableImport = Buff.getOptionalJPgSqlTableImport();
			String JPgSqlTableMembers = Buff.getOptionalJPgSqlTableMembers();
			String JPgSqlTableImplementation = Buff.getOptionalJPgSqlTableImplementation();
			String JRamTableImport = Buff.getOptionalJRamTableImport();
			String JRamTableMembers = Buff.getOptionalJRamTableMembers();
			String JRamTableImplementation = Buff.getOptionalJRamTableImplementation();
			String JSaxLoaderImport = Buff.getOptionalJSaxLoaderImport();
			String JSaxLoaderStartElement = Buff.getOptionalJSaxLoaderStartElement();
			String JSaxLoaderEndElement = Buff.getOptionalJSaxLoaderEndElement();
			String JXMsgTableImport = Buff.getOptionalJXMsgTableImport();
			String JXMsgTableFormatters = Buff.getOptionalJXMsgTableFormatters();
			String JXMsgRqstTableImport = Buff.getOptionalJXMsgRqstTableImport();
			String JXMsgRspnTableImport = Buff.getOptionalJXMsgRspnTableImport();
			String JXMsgClientTableImport = Buff.getOptionalJXMsgClientTableImport();
			String JXMsgRqstTableBody = Buff.getOptionalJXMsgRqstTableBody();
			String JXMsgRspnTableBody = Buff.getOptionalJXMsgRspnTableBody();
			String JXMsgClientTableBody = Buff.getOptionalJXMsgClientTableBody();
			String CppObjMembers = Buff.getOptionalCppObjMembers();
			String CppObjInterface = Buff.getOptionalCppObjInterface();
			String CppObjInclude = Buff.getOptionalCppObjInclude();
			String CppObjImplementation = Buff.getOptionalCppObjImplementation();
			String CppEditObjMembers = Buff.getOptionalCppEditObjMembers();
			String CppEditObjInterface = Buff.getOptionalCppEditObjInterface();
			String CppEditObjInclude = Buff.getOptionalCppEditObjInclude();
			String CppEditObjImplementation = Buff.getOptionalCppEditObjImplementation();
			String CppTableInclude = Buff.getOptionalCppTableInclude();
			String CppTableMembers = Buff.getOptionalCppTableMembers();
			String CppTableInterface = Buff.getOptionalCppTableInterface();
			String CppTableImplementation = Buff.getOptionalCppTableImplementation();
			String CppTableObjInclude = Buff.getOptionalCppTableObjInclude();
			String CppTableObjMembers = Buff.getOptionalCppTableObjMembers();
			String CppTableObjInterface = Buff.getOptionalCppTableObjInterface();
			String CppTableObjImplementation = Buff.getOptionalCppTableObjImplementation();
			String CppDb2LUWTableInclude = Buff.getOptionalCppDb2LUWTableInclude();
			String CppDb2LUWTableMembers = Buff.getOptionalCppDb2LUWTableMembers();
			String CppDb2LUWTableImplementation = Buff.getOptionalCppDb2LUWTableImplementation();
			String CppMSSqlTableInclude = Buff.getOptionalCppMSSqlTableInclude();
			String CppMSSqlTableMembers = Buff.getOptionalCppMSSqlTableMembers();
			String CppMSSqlTableImplementation = Buff.getOptionalCppMSSqlTableImplementation();
			String CppMySqlTableInclude = Buff.getOptionalCppMySqlTableInclude();
			String CppMySqlTableMembers = Buff.getOptionalCppMySqlTableMembers();
			String CppMySqlTableImplementation = Buff.getOptionalCppMySqlTableImplementation();
			String CppOracleTableInclude = Buff.getOptionalCppOracleTableInclude();
			String CppOracleTableMembers = Buff.getOptionalCppOracleTableMembers();
			String CppOracleTableImplementation = Buff.getOptionalCppOracleTableImplementation();
			String CppPgSqlTableInclude = Buff.getOptionalCppPgSqlTableInclude();
			String CppPgSqlTableMembers = Buff.getOptionalCppPgSqlTableMembers();
			String CppPgSqlTableImplementation = Buff.getOptionalCppPgSqlTableImplementation();
			String CppRamTableInclude = Buff.getOptionalCppRamTableInclude();
			String CppRamTableMembers = Buff.getOptionalCppRamTableMembers();
			String CppRamTableImplementation = Buff.getOptionalCppRamTableImplementation();
			String CppSaxLoaderInclude = Buff.getOptionalCppSaxLoaderInclude();
			String CppSaxLoaderStartElement = Buff.getOptionalCppSaxLoaderStartElement();
			String CppSaxLoaderEndElement = Buff.getOptionalCppSaxLoaderEndElement();
			String CppXMsgTableInclude = Buff.getOptionalCppXMsgTableInclude();
			String CppXMsgTableFormatters = Buff.getOptionalCppXMsgTableFormatters();
			String CppXMsgRqstTableInclude = Buff.getOptionalCppXMsgRqstTableInclude();
			String CppXMsgRspnTableInclude = Buff.getOptionalCppXMsgRspnTableInclude();
			String CppXMsgClientTableInclude = Buff.getOptionalCppXMsgClientTableInclude();
			String CppXMsgRqstTableBody = Buff.getOptionalCppXMsgRqstTableBody();
			String CppXMsgRspnTableBody = Buff.getOptionalCppXMsgRspnTableBody();
			String CppXMsgClientTableBody = Buff.getOptionalCppXMsgClientTableBody();
			String HppObjMembers = Buff.getOptionalHppObjMembers();
			String HppObjInterface = Buff.getOptionalHppObjInterface();
			String HppObjInclude = Buff.getOptionalHppObjInclude();
			String HppObjImplementation = Buff.getOptionalHppObjImplementation();
			String HppEditObjMembers = Buff.getOptionalHppEditObjMembers();
			String HppEditObjInterface = Buff.getOptionalHppEditObjInterface();
			String HppEditObjInclude = Buff.getOptionalHppEditObjInclude();
			String HppEditObjImplementation = Buff.getOptionalHppEditObjImplementation();
			String HppTableInclude = Buff.getOptionalHppTableInclude();
			String HppTableMembers = Buff.getOptionalHppTableMembers();
			String HppTableInterface = Buff.getOptionalHppTableInterface();
			String HppTableImplementation = Buff.getOptionalHppTableImplementation();
			String HppTableObjInclude = Buff.getOptionalHppTableObjInclude();
			String HppTableObjMembers = Buff.getOptionalHppTableObjMembers();
			String HppTableObjInterface = Buff.getOptionalHppTableObjInterface();
			String HppTableObjImplementation = Buff.getOptionalHppTableObjImplementation();
			String HppDb2LUWTableInclude = Buff.getOptionalHppDb2LUWTableInclude();
			String HppDb2LUWTableMembers = Buff.getOptionalHppDb2LUWTableMembers();
			String HppDb2LUWTableImplementation = Buff.getOptionalHppDb2LUWTableImplementation();
			String HppMSSqlTableInclude = Buff.getOptionalHppMSSqlTableInclude();
			String HppMSSqlTableMembers = Buff.getOptionalHppMSSqlTableMembers();
			String HppMSSqlTableImplementation = Buff.getOptionalHppMSSqlTableImplementation();
			String HppMySqlTableInclude = Buff.getOptionalHppMySqlTableInclude();
			String HppMySqlTableMembers = Buff.getOptionalHppMySqlTableMembers();
			String HppMySqlTableImplementation = Buff.getOptionalHppMySqlTableImplementation();
			String HppOracleTableInclude = Buff.getOptionalHppOracleTableInclude();
			String HppOracleTableMembers = Buff.getOptionalHppOracleTableMembers();
			String HppOracleTableImplementation = Buff.getOptionalHppOracleTableImplementation();
			String HppPgSqlTableInclude = Buff.getOptionalHppPgSqlTableInclude();
			String HppPgSqlTableMembers = Buff.getOptionalHppPgSqlTableMembers();
			String HppPgSqlTableImplementation = Buff.getOptionalHppPgSqlTableImplementation();
			String HppRamTableInclude = Buff.getOptionalHppRamTableInclude();
			String HppRamTableMembers = Buff.getOptionalHppRamTableMembers();
			String HppRamTableImplementation = Buff.getOptionalHppRamTableImplementation();
			String HppSaxLoaderInclude = Buff.getOptionalHppSaxLoaderInclude();
			String HppSaxLoaderStartElement = Buff.getOptionalHppSaxLoaderStartElement();
			String HppSaxLoaderEndElement = Buff.getOptionalHppSaxLoaderEndElement();
			String HppXMsgTableInclude = Buff.getOptionalHppXMsgTableInclude();
			String HppXMsgTableFormatters = Buff.getOptionalHppXMsgTableFormatters();
			String HppXMsgRqstTableInclude = Buff.getOptionalHppXMsgRqstTableInclude();
			String HppXMsgRspnTableInclude = Buff.getOptionalHppXMsgRspnTableInclude();
			String HppXMsgClientTableInclude = Buff.getOptionalHppXMsgClientTableInclude();
			String HppXMsgRqstTableBody = Buff.getOptionalHppXMsgRqstTableBody();
			String HppXMsgRspnTableBody = Buff.getOptionalHppXMsgRspnTableBody();
			String HppXMsgClientTableBody = Buff.getOptionalHppXMsgClientTableBody();
			String CsObjMembers = Buff.getOptionalCsObjMembers();
			String CsObjInterface = Buff.getOptionalCsObjInterface();
			String CsObjUsing = Buff.getOptionalCsObjUsing();
			String CsObjImplementation = Buff.getOptionalCsObjImplementation();
			String CsEditObjMembers = Buff.getOptionalCsEditObjMembers();
			String CsEditObjInterface = Buff.getOptionalCsEditObjInterface();
			String CsEditObjUsing = Buff.getOptionalCsEditObjUsing();
			String CsEditObjImplementation = Buff.getOptionalCsEditObjImplementation();
			String CsTableUsing = Buff.getOptionalCsTableUsing();
			String CsTableMembers = Buff.getOptionalCsTableMembers();
			String CsTableInterface = Buff.getOptionalCsTableInterface();
			String CsTableImplementation = Buff.getOptionalCsTableImplementation();
			String CsTableObjUsing = Buff.getOptionalCsTableObjUsing();
			String CsTableObjMembers = Buff.getOptionalCsTableObjMembers();
			String CsTableObjInterface = Buff.getOptionalCsTableObjInterface();
			String CsTableObjImplementation = Buff.getOptionalCsTableObjImplementation();
			String CsDb2LUWTableUsing = Buff.getOptionalCsDb2LUWTableUsing();
			String CsDb2LUWTableMembers = Buff.getOptionalCsDb2LUWTableMembers();
			String CsDb2LUWTableImplementation = Buff.getOptionalCsDb2LUWTableImplementation();
			String CsMSSqlTableUsing = Buff.getOptionalCsMSSqlTableUsing();
			String CsMSSqlTableMembers = Buff.getOptionalCsMSSqlTableMembers();
			String CsMSSqlTableImplementation = Buff.getOptionalCsMSSqlTableImplementation();
			String CsMySqlTableUsing = Buff.getOptionalCsMySqlTableUsing();
			String CsMySqlTableMembers = Buff.getOptionalCsMySqlTableMembers();
			String CsMySqlTableImplementation = Buff.getOptionalCsMySqlTableImplementation();
			String CsOracleTableUsing = Buff.getOptionalCsOracleTableUsing();
			String CsOracleTableMembers = Buff.getOptionalCsOracleTableMembers();
			String CsOracleTableImplementation = Buff.getOptionalCsOracleTableImplementation();
			String CsPgSqlTableUsing = Buff.getOptionalCsPgSqlTableUsing();
			String CsPgSqlTableMembers = Buff.getOptionalCsPgSqlTableMembers();
			String CsPgSqlTableImplementation = Buff.getOptionalCsPgSqlTableImplementation();
			String CsRamTableUsing = Buff.getOptionalCsRamTableUsing();
			String CsRamTableMembers = Buff.getOptionalCsRamTableMembers();
			String CsRamTableImplementation = Buff.getOptionalCsRamTableImplementation();
			String CsSaxLoaderUsing = Buff.getOptionalCsSaxLoaderUsing();
			String CsSaxLoaderStartElement = Buff.getOptionalCsSaxLoaderStartElement();
			String CsSaxLoaderEndElement = Buff.getOptionalCsSaxLoaderEndElement();
			String CsXMsgTableUsing = Buff.getOptionalCsXMsgTableUsing();
			String CsXMsgTableFormatters = Buff.getOptionalCsXMsgTableFormatters();
			String CsXMsgRqstTableUsing = Buff.getOptionalCsXMsgRqstTableUsing();
			String CsXMsgRspnTableUsing = Buff.getOptionalCsXMsgRspnTableUsing();
			String CsXMsgClientTableUsing = Buff.getOptionalCsXMsgClientTableUsing();
			String CsXMsgRqstTableBody = Buff.getOptionalCsXMsgRqstTableBody();
			String CsXMsgRspnTableBody = Buff.getOptionalCsXMsgRspnTableBody();
			String CsXMsgClientTableBody = Buff.getOptionalCsXMsgClientTableBody();
			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_tbldef( ?, ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtCreateByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, ClassCode );
			stmtCreateByPKey.setLong( argIdx++, TenantId );
			stmtCreateByPKey.setLong( argIdx++, SchemaDefId );
			if( DefSchemaTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtCreateByPKey.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtCreateByPKey.setString( argIdx++, Name );
			if( DbName != null ) {
				stmtCreateByPKey.setString( argIdx++, DbName );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ShortName != null ) {
				stmtCreateByPKey.setString( argIdx++, ShortName );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Label != null ) {
				stmtCreateByPKey.setString( argIdx++, Label );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ShortDescription != null ) {
				stmtCreateByPKey.setString( argIdx++, ShortDescription );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Description != null ) {
				stmtCreateByPKey.setString( argIdx++, Description );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( PageData ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( PrimaryIndexTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, PrimaryIndexTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrimaryIndexId != null ) {
				stmtCreateByPKey.setLong( argIdx++, PrimaryIndexId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtCreateByPKey.setString( argIdx++, TableClassCode );
			if( LookupIndexTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, LookupIndexTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( LookupIndexId != null ) {
				stmtCreateByPKey.setLong( argIdx++, LookupIndexId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, AltIndexTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexId != null ) {
				stmtCreateByPKey.setLong( argIdx++, AltIndexId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, QualifyingTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTableId != null ) {
				stmtCreateByPKey.setLong( argIdx++, QualifyingTableId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( IsInstantiable ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( HasHistory ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( HasAuditColumns ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( IsMutable ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( IsServerOnly ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			stmtCreateByPKey.setShort( argIdx++, (short)LoaderBehaviour.ordinal() );
			stmtCreateByPKey.setShort( argIdx++, (short)SecScope.ordinal() );
			if( JObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, JObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JEditObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JEditObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JEditObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, JEditObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JEditObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JEditObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JEditObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JEditObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableObjImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableObjImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JTableObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JDb2LUWTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JDb2LUWTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JDb2LUWTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JDb2LUWTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JDb2LUWTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JDb2LUWTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMSSqlTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JMSSqlTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMSSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JMSSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMSSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JMSSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMySqlTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JMySqlTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMySqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JMySqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMySqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JMySqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JOracleTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JOracleTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JOracleTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JOracleTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JOracleTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JOracleTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JPgSqlTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JPgSqlTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JPgSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JPgSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JPgSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JPgSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JRamTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JRamTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JRamTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, JRamTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JRamTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, JRamTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JSaxLoaderImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JSaxLoaderImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JSaxLoaderStartElement != null ) {
				stmtCreateByPKey.setString( argIdx++, JSaxLoaderStartElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JSaxLoaderEndElement != null ) {
				stmtCreateByPKey.setString( argIdx++, JSaxLoaderEndElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgTableFormatters != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgTableFormatters );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgRqstTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRqstTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgRspnTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRspnTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgClientTableImport != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgClientTableImport );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgRqstTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRqstTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgRspnTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgRspnTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgClientTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, JXMsgClientTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, CppObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppObjInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppObjInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppEditObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppEditObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppEditObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, CppEditObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppEditObjInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppEditObjInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppEditObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppEditObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, CppTableInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableObjInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppTableObjInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppTableObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, CppTableObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppTableObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppDb2LUWTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppDb2LUWTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppDb2LUWTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppDb2LUWTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppDb2LUWTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppDb2LUWTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMSSqlTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppMSSqlTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMSSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppMSSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMSSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppMSSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMySqlTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppMySqlTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMySqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppMySqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMySqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppMySqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppOracleTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppOracleTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppOracleTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppOracleTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppOracleTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppOracleTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppPgSqlTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppPgSqlTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppPgSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppPgSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppPgSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppPgSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppRamTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppRamTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppRamTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CppRamTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppRamTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CppRamTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppSaxLoaderInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppSaxLoaderInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppSaxLoaderStartElement != null ) {
				stmtCreateByPKey.setString( argIdx++, CppSaxLoaderStartElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppSaxLoaderEndElement != null ) {
				stmtCreateByPKey.setString( argIdx++, CppSaxLoaderEndElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppXMsgTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgTableFormatters != null ) {
				stmtCreateByPKey.setString( argIdx++, CppXMsgTableFormatters );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgRqstTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppXMsgRqstTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgRspnTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppXMsgRspnTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgClientTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, CppXMsgClientTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgRqstTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, CppXMsgRqstTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgRspnTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, CppXMsgRspnTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgClientTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, CppXMsgClientTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, HppObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppObjInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppObjInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppEditObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppEditObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppEditObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, HppEditObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppEditObjInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppEditObjInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppEditObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppEditObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, HppTableInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableObjInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppTableObjInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppTableObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, HppTableObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppTableObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppDb2LUWTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppDb2LUWTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppDb2LUWTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppDb2LUWTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppDb2LUWTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppDb2LUWTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMSSqlTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppMSSqlTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMSSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppMSSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMSSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppMSSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMySqlTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppMySqlTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMySqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppMySqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMySqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppMySqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppOracleTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppOracleTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppOracleTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppOracleTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppOracleTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppOracleTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppPgSqlTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppPgSqlTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppPgSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppPgSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppPgSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppPgSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppRamTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppRamTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppRamTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, HppRamTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppRamTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, HppRamTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppSaxLoaderInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppSaxLoaderInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppSaxLoaderStartElement != null ) {
				stmtCreateByPKey.setString( argIdx++, HppSaxLoaderStartElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppSaxLoaderEndElement != null ) {
				stmtCreateByPKey.setString( argIdx++, HppSaxLoaderEndElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppXMsgTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgTableFormatters != null ) {
				stmtCreateByPKey.setString( argIdx++, HppXMsgTableFormatters );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgRqstTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppXMsgRqstTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgRspnTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppXMsgRspnTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgClientTableInclude != null ) {
				stmtCreateByPKey.setString( argIdx++, HppXMsgClientTableInclude );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgRqstTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, HppXMsgRqstTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgRspnTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, HppXMsgRspnTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgClientTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, HppXMsgClientTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, CsObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsObjUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsObjUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsEditObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsEditObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsEditObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, CsEditObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsEditObjUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsEditObjUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsEditObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsEditObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, CsTableInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableObjUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsTableObjUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableObjMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsTableObjMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableObjInterface != null ) {
				stmtCreateByPKey.setString( argIdx++, CsTableObjInterface );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableObjImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsTableObjImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsDb2LUWTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsDb2LUWTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsDb2LUWTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsDb2LUWTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsDb2LUWTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsDb2LUWTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMSSqlTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsMSSqlTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMSSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsMSSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMSSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsMSSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMySqlTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsMySqlTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMySqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsMySqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMySqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsMySqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsOracleTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsOracleTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsOracleTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsOracleTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsOracleTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsOracleTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsPgSqlTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsPgSqlTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsPgSqlTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsPgSqlTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsPgSqlTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsPgSqlTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsRamTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsRamTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsRamTableMembers != null ) {
				stmtCreateByPKey.setString( argIdx++, CsRamTableMembers );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsRamTableImplementation != null ) {
				stmtCreateByPKey.setString( argIdx++, CsRamTableImplementation );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsSaxLoaderUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsSaxLoaderUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsSaxLoaderStartElement != null ) {
				stmtCreateByPKey.setString( argIdx++, CsSaxLoaderStartElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsSaxLoaderEndElement != null ) {
				stmtCreateByPKey.setString( argIdx++, CsSaxLoaderEndElement );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsXMsgTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgTableFormatters != null ) {
				stmtCreateByPKey.setString( argIdx++, CsXMsgTableFormatters );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgRqstTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsXMsgRqstTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgRspnTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsXMsgRspnTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgClientTableUsing != null ) {
				stmtCreateByPKey.setString( argIdx++, CsXMsgClientTableUsing );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgRqstTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, CsXMsgRqstTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgRspnTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, CsXMsgRspnTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgClientTableBody != null ) {
				stmtCreateByPKey.setString( argIdx++, CsXMsgClientTableBody );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"crt_tbldef() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamTableBuff createdBuff = unpackTableResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
				Buff.setRequiredTenantId( createdBuff.getRequiredTenantId() );
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setRequiredRevision( createdBuff.getRequiredRevision() );
				Buff.setCreatedByUserId( createdBuff.getCreatedByUserId() );
				Buff.setCreatedAt( createdBuff.getCreatedAt() );
				Buff.setUpdatedByUserId( createdBuff.getUpdatedByUserId() );
				Buff.setUpdatedAt( createdBuff.getUpdatedAt() );
				Buff.setRequiredSchemaDefId( createdBuff.getRequiredSchemaDefId() );
				Buff.setOptionalDefSchemaTenantId( createdBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( createdBuff.getOptionalDefSchemaId() );
				Buff.setRequiredName( createdBuff.getRequiredName() );
				Buff.setOptionalDbName( createdBuff.getOptionalDbName() );
				Buff.setOptionalShortName( createdBuff.getOptionalShortName() );
				Buff.setOptionalLabel( createdBuff.getOptionalLabel() );
				Buff.setOptionalShortDescription( createdBuff.getOptionalShortDescription() );
				Buff.setOptionalDescription( createdBuff.getOptionalDescription() );
				Buff.setRequiredPageData( createdBuff.getRequiredPageData() );
				Buff.setOptionalPrimaryIndexTenantId( createdBuff.getOptionalPrimaryIndexTenantId() );
				Buff.setOptionalPrimaryIndexId( createdBuff.getOptionalPrimaryIndexId() );
				Buff.setRequiredTableClassCode( createdBuff.getRequiredTableClassCode() );
				Buff.setOptionalLookupIndexTenantId( createdBuff.getOptionalLookupIndexTenantId() );
				Buff.setOptionalLookupIndexId( createdBuff.getOptionalLookupIndexId() );
				Buff.setOptionalAltIndexTenantId( createdBuff.getOptionalAltIndexTenantId() );
				Buff.setOptionalAltIndexId( createdBuff.getOptionalAltIndexId() );
				Buff.setOptionalQualifyingTenantId( createdBuff.getOptionalQualifyingTenantId() );
				Buff.setOptionalQualifyingTableId( createdBuff.getOptionalQualifyingTableId() );
				Buff.setRequiredIsInstantiable( createdBuff.getRequiredIsInstantiable() );
				Buff.setRequiredHasHistory( createdBuff.getRequiredHasHistory() );
				Buff.setRequiredHasAuditColumns( createdBuff.getRequiredHasAuditColumns() );
				Buff.setRequiredIsMutable( createdBuff.getRequiredIsMutable() );
				Buff.setRequiredIsServerOnly( createdBuff.getRequiredIsServerOnly() );
				Buff.setRequiredLoaderBehaviour( createdBuff.getRequiredLoaderBehaviour() );
				Buff.setRequiredSecScope( createdBuff.getRequiredSecScope() );
				Buff.setOptionalJObjMembers( createdBuff.getOptionalJObjMembers() );
				Buff.setOptionalJObjInterface( createdBuff.getOptionalJObjInterface() );
				Buff.setOptionalJObjImport( createdBuff.getOptionalJObjImport() );
				Buff.setOptionalJObjImplementation( createdBuff.getOptionalJObjImplementation() );
				Buff.setOptionalJEditObjMembers( createdBuff.getOptionalJEditObjMembers() );
				Buff.setOptionalJEditObjInterface( createdBuff.getOptionalJEditObjInterface() );
				Buff.setOptionalJEditObjImport( createdBuff.getOptionalJEditObjImport() );
				Buff.setOptionalJEditObjImplementation( createdBuff.getOptionalJEditObjImplementation() );
				Buff.setOptionalJTableImport( createdBuff.getOptionalJTableImport() );
				Buff.setOptionalJTableMembers( createdBuff.getOptionalJTableMembers() );
				Buff.setOptionalJTableInterface( createdBuff.getOptionalJTableInterface() );
				Buff.setOptionalJTableImplementation( createdBuff.getOptionalJTableImplementation() );
				Buff.setOptionalJTableObjImport( createdBuff.getOptionalJTableObjImport() );
				Buff.setOptionalJTableObjMembers( createdBuff.getOptionalJTableObjMembers() );
				Buff.setOptionalJTableObjInterface( createdBuff.getOptionalJTableObjInterface() );
				Buff.setOptionalJTableObjImplementation( createdBuff.getOptionalJTableObjImplementation() );
				Buff.setOptionalJDb2LUWTableImport( createdBuff.getOptionalJDb2LUWTableImport() );
				Buff.setOptionalJDb2LUWTableMembers( createdBuff.getOptionalJDb2LUWTableMembers() );
				Buff.setOptionalJDb2LUWTableImplementation( createdBuff.getOptionalJDb2LUWTableImplementation() );
				Buff.setOptionalJMSSqlTableImport( createdBuff.getOptionalJMSSqlTableImport() );
				Buff.setOptionalJMSSqlTableMembers( createdBuff.getOptionalJMSSqlTableMembers() );
				Buff.setOptionalJMSSqlTableImplementation( createdBuff.getOptionalJMSSqlTableImplementation() );
				Buff.setOptionalJMySqlTableImport( createdBuff.getOptionalJMySqlTableImport() );
				Buff.setOptionalJMySqlTableMembers( createdBuff.getOptionalJMySqlTableMembers() );
				Buff.setOptionalJMySqlTableImplementation( createdBuff.getOptionalJMySqlTableImplementation() );
				Buff.setOptionalJOracleTableImport( createdBuff.getOptionalJOracleTableImport() );
				Buff.setOptionalJOracleTableMembers( createdBuff.getOptionalJOracleTableMembers() );
				Buff.setOptionalJOracleTableImplementation( createdBuff.getOptionalJOracleTableImplementation() );
				Buff.setOptionalJPgSqlTableImport( createdBuff.getOptionalJPgSqlTableImport() );
				Buff.setOptionalJPgSqlTableMembers( createdBuff.getOptionalJPgSqlTableMembers() );
				Buff.setOptionalJPgSqlTableImplementation( createdBuff.getOptionalJPgSqlTableImplementation() );
				Buff.setOptionalJRamTableImport( createdBuff.getOptionalJRamTableImport() );
				Buff.setOptionalJRamTableMembers( createdBuff.getOptionalJRamTableMembers() );
				Buff.setOptionalJRamTableImplementation( createdBuff.getOptionalJRamTableImplementation() );
				Buff.setOptionalJSaxLoaderImport( createdBuff.getOptionalJSaxLoaderImport() );
				Buff.setOptionalJSaxLoaderStartElement( createdBuff.getOptionalJSaxLoaderStartElement() );
				Buff.setOptionalJSaxLoaderEndElement( createdBuff.getOptionalJSaxLoaderEndElement() );
				Buff.setOptionalJXMsgTableImport( createdBuff.getOptionalJXMsgTableImport() );
				Buff.setOptionalJXMsgTableFormatters( createdBuff.getOptionalJXMsgTableFormatters() );
				Buff.setOptionalJXMsgRqstTableImport( createdBuff.getOptionalJXMsgRqstTableImport() );
				Buff.setOptionalJXMsgRspnTableImport( createdBuff.getOptionalJXMsgRspnTableImport() );
				Buff.setOptionalJXMsgClientTableImport( createdBuff.getOptionalJXMsgClientTableImport() );
				Buff.setOptionalJXMsgRqstTableBody( createdBuff.getOptionalJXMsgRqstTableBody() );
				Buff.setOptionalJXMsgRspnTableBody( createdBuff.getOptionalJXMsgRspnTableBody() );
				Buff.setOptionalJXMsgClientTableBody( createdBuff.getOptionalJXMsgClientTableBody() );
				Buff.setOptionalCppObjMembers( createdBuff.getOptionalCppObjMembers() );
				Buff.setOptionalCppObjInterface( createdBuff.getOptionalCppObjInterface() );
				Buff.setOptionalCppObjInclude( createdBuff.getOptionalCppObjInclude() );
				Buff.setOptionalCppObjImplementation( createdBuff.getOptionalCppObjImplementation() );
				Buff.setOptionalCppEditObjMembers( createdBuff.getOptionalCppEditObjMembers() );
				Buff.setOptionalCppEditObjInterface( createdBuff.getOptionalCppEditObjInterface() );
				Buff.setOptionalCppEditObjInclude( createdBuff.getOptionalCppEditObjInclude() );
				Buff.setOptionalCppEditObjImplementation( createdBuff.getOptionalCppEditObjImplementation() );
				Buff.setOptionalCppTableInclude( createdBuff.getOptionalCppTableInclude() );
				Buff.setOptionalCppTableMembers( createdBuff.getOptionalCppTableMembers() );
				Buff.setOptionalCppTableInterface( createdBuff.getOptionalCppTableInterface() );
				Buff.setOptionalCppTableImplementation( createdBuff.getOptionalCppTableImplementation() );
				Buff.setOptionalCppTableObjInclude( createdBuff.getOptionalCppTableObjInclude() );
				Buff.setOptionalCppTableObjMembers( createdBuff.getOptionalCppTableObjMembers() );
				Buff.setOptionalCppTableObjInterface( createdBuff.getOptionalCppTableObjInterface() );
				Buff.setOptionalCppTableObjImplementation( createdBuff.getOptionalCppTableObjImplementation() );
				Buff.setOptionalCppDb2LUWTableInclude( createdBuff.getOptionalCppDb2LUWTableInclude() );
				Buff.setOptionalCppDb2LUWTableMembers( createdBuff.getOptionalCppDb2LUWTableMembers() );
				Buff.setOptionalCppDb2LUWTableImplementation( createdBuff.getOptionalCppDb2LUWTableImplementation() );
				Buff.setOptionalCppMSSqlTableInclude( createdBuff.getOptionalCppMSSqlTableInclude() );
				Buff.setOptionalCppMSSqlTableMembers( createdBuff.getOptionalCppMSSqlTableMembers() );
				Buff.setOptionalCppMSSqlTableImplementation( createdBuff.getOptionalCppMSSqlTableImplementation() );
				Buff.setOptionalCppMySqlTableInclude( createdBuff.getOptionalCppMySqlTableInclude() );
				Buff.setOptionalCppMySqlTableMembers( createdBuff.getOptionalCppMySqlTableMembers() );
				Buff.setOptionalCppMySqlTableImplementation( createdBuff.getOptionalCppMySqlTableImplementation() );
				Buff.setOptionalCppOracleTableInclude( createdBuff.getOptionalCppOracleTableInclude() );
				Buff.setOptionalCppOracleTableMembers( createdBuff.getOptionalCppOracleTableMembers() );
				Buff.setOptionalCppOracleTableImplementation( createdBuff.getOptionalCppOracleTableImplementation() );
				Buff.setOptionalCppPgSqlTableInclude( createdBuff.getOptionalCppPgSqlTableInclude() );
				Buff.setOptionalCppPgSqlTableMembers( createdBuff.getOptionalCppPgSqlTableMembers() );
				Buff.setOptionalCppPgSqlTableImplementation( createdBuff.getOptionalCppPgSqlTableImplementation() );
				Buff.setOptionalCppRamTableInclude( createdBuff.getOptionalCppRamTableInclude() );
				Buff.setOptionalCppRamTableMembers( createdBuff.getOptionalCppRamTableMembers() );
				Buff.setOptionalCppRamTableImplementation( createdBuff.getOptionalCppRamTableImplementation() );
				Buff.setOptionalCppSaxLoaderInclude( createdBuff.getOptionalCppSaxLoaderInclude() );
				Buff.setOptionalCppSaxLoaderStartElement( createdBuff.getOptionalCppSaxLoaderStartElement() );
				Buff.setOptionalCppSaxLoaderEndElement( createdBuff.getOptionalCppSaxLoaderEndElement() );
				Buff.setOptionalCppXMsgTableInclude( createdBuff.getOptionalCppXMsgTableInclude() );
				Buff.setOptionalCppXMsgTableFormatters( createdBuff.getOptionalCppXMsgTableFormatters() );
				Buff.setOptionalCppXMsgRqstTableInclude( createdBuff.getOptionalCppXMsgRqstTableInclude() );
				Buff.setOptionalCppXMsgRspnTableInclude( createdBuff.getOptionalCppXMsgRspnTableInclude() );
				Buff.setOptionalCppXMsgClientTableInclude( createdBuff.getOptionalCppXMsgClientTableInclude() );
				Buff.setOptionalCppXMsgRqstTableBody( createdBuff.getOptionalCppXMsgRqstTableBody() );
				Buff.setOptionalCppXMsgRspnTableBody( createdBuff.getOptionalCppXMsgRspnTableBody() );
				Buff.setOptionalCppXMsgClientTableBody( createdBuff.getOptionalCppXMsgClientTableBody() );
				Buff.setOptionalHppObjMembers( createdBuff.getOptionalHppObjMembers() );
				Buff.setOptionalHppObjInterface( createdBuff.getOptionalHppObjInterface() );
				Buff.setOptionalHppObjInclude( createdBuff.getOptionalHppObjInclude() );
				Buff.setOptionalHppObjImplementation( createdBuff.getOptionalHppObjImplementation() );
				Buff.setOptionalHppEditObjMembers( createdBuff.getOptionalHppEditObjMembers() );
				Buff.setOptionalHppEditObjInterface( createdBuff.getOptionalHppEditObjInterface() );
				Buff.setOptionalHppEditObjInclude( createdBuff.getOptionalHppEditObjInclude() );
				Buff.setOptionalHppEditObjImplementation( createdBuff.getOptionalHppEditObjImplementation() );
				Buff.setOptionalHppTableInclude( createdBuff.getOptionalHppTableInclude() );
				Buff.setOptionalHppTableMembers( createdBuff.getOptionalHppTableMembers() );
				Buff.setOptionalHppTableInterface( createdBuff.getOptionalHppTableInterface() );
				Buff.setOptionalHppTableImplementation( createdBuff.getOptionalHppTableImplementation() );
				Buff.setOptionalHppTableObjInclude( createdBuff.getOptionalHppTableObjInclude() );
				Buff.setOptionalHppTableObjMembers( createdBuff.getOptionalHppTableObjMembers() );
				Buff.setOptionalHppTableObjInterface( createdBuff.getOptionalHppTableObjInterface() );
				Buff.setOptionalHppTableObjImplementation( createdBuff.getOptionalHppTableObjImplementation() );
				Buff.setOptionalHppDb2LUWTableInclude( createdBuff.getOptionalHppDb2LUWTableInclude() );
				Buff.setOptionalHppDb2LUWTableMembers( createdBuff.getOptionalHppDb2LUWTableMembers() );
				Buff.setOptionalHppDb2LUWTableImplementation( createdBuff.getOptionalHppDb2LUWTableImplementation() );
				Buff.setOptionalHppMSSqlTableInclude( createdBuff.getOptionalHppMSSqlTableInclude() );
				Buff.setOptionalHppMSSqlTableMembers( createdBuff.getOptionalHppMSSqlTableMembers() );
				Buff.setOptionalHppMSSqlTableImplementation( createdBuff.getOptionalHppMSSqlTableImplementation() );
				Buff.setOptionalHppMySqlTableInclude( createdBuff.getOptionalHppMySqlTableInclude() );
				Buff.setOptionalHppMySqlTableMembers( createdBuff.getOptionalHppMySqlTableMembers() );
				Buff.setOptionalHppMySqlTableImplementation( createdBuff.getOptionalHppMySqlTableImplementation() );
				Buff.setOptionalHppOracleTableInclude( createdBuff.getOptionalHppOracleTableInclude() );
				Buff.setOptionalHppOracleTableMembers( createdBuff.getOptionalHppOracleTableMembers() );
				Buff.setOptionalHppOracleTableImplementation( createdBuff.getOptionalHppOracleTableImplementation() );
				Buff.setOptionalHppPgSqlTableInclude( createdBuff.getOptionalHppPgSqlTableInclude() );
				Buff.setOptionalHppPgSqlTableMembers( createdBuff.getOptionalHppPgSqlTableMembers() );
				Buff.setOptionalHppPgSqlTableImplementation( createdBuff.getOptionalHppPgSqlTableImplementation() );
				Buff.setOptionalHppRamTableInclude( createdBuff.getOptionalHppRamTableInclude() );
				Buff.setOptionalHppRamTableMembers( createdBuff.getOptionalHppRamTableMembers() );
				Buff.setOptionalHppRamTableImplementation( createdBuff.getOptionalHppRamTableImplementation() );
				Buff.setOptionalHppSaxLoaderInclude( createdBuff.getOptionalHppSaxLoaderInclude() );
				Buff.setOptionalHppSaxLoaderStartElement( createdBuff.getOptionalHppSaxLoaderStartElement() );
				Buff.setOptionalHppSaxLoaderEndElement( createdBuff.getOptionalHppSaxLoaderEndElement() );
				Buff.setOptionalHppXMsgTableInclude( createdBuff.getOptionalHppXMsgTableInclude() );
				Buff.setOptionalHppXMsgTableFormatters( createdBuff.getOptionalHppXMsgTableFormatters() );
				Buff.setOptionalHppXMsgRqstTableInclude( createdBuff.getOptionalHppXMsgRqstTableInclude() );
				Buff.setOptionalHppXMsgRspnTableInclude( createdBuff.getOptionalHppXMsgRspnTableInclude() );
				Buff.setOptionalHppXMsgClientTableInclude( createdBuff.getOptionalHppXMsgClientTableInclude() );
				Buff.setOptionalHppXMsgRqstTableBody( createdBuff.getOptionalHppXMsgRqstTableBody() );
				Buff.setOptionalHppXMsgRspnTableBody( createdBuff.getOptionalHppXMsgRspnTableBody() );
				Buff.setOptionalHppXMsgClientTableBody( createdBuff.getOptionalHppXMsgClientTableBody() );
				Buff.setOptionalCsObjMembers( createdBuff.getOptionalCsObjMembers() );
				Buff.setOptionalCsObjInterface( createdBuff.getOptionalCsObjInterface() );
				Buff.setOptionalCsObjUsing( createdBuff.getOptionalCsObjUsing() );
				Buff.setOptionalCsObjImplementation( createdBuff.getOptionalCsObjImplementation() );
				Buff.setOptionalCsEditObjMembers( createdBuff.getOptionalCsEditObjMembers() );
				Buff.setOptionalCsEditObjInterface( createdBuff.getOptionalCsEditObjInterface() );
				Buff.setOptionalCsEditObjUsing( createdBuff.getOptionalCsEditObjUsing() );
				Buff.setOptionalCsEditObjImplementation( createdBuff.getOptionalCsEditObjImplementation() );
				Buff.setOptionalCsTableUsing( createdBuff.getOptionalCsTableUsing() );
				Buff.setOptionalCsTableMembers( createdBuff.getOptionalCsTableMembers() );
				Buff.setOptionalCsTableInterface( createdBuff.getOptionalCsTableInterface() );
				Buff.setOptionalCsTableImplementation( createdBuff.getOptionalCsTableImplementation() );
				Buff.setOptionalCsTableObjUsing( createdBuff.getOptionalCsTableObjUsing() );
				Buff.setOptionalCsTableObjMembers( createdBuff.getOptionalCsTableObjMembers() );
				Buff.setOptionalCsTableObjInterface( createdBuff.getOptionalCsTableObjInterface() );
				Buff.setOptionalCsTableObjImplementation( createdBuff.getOptionalCsTableObjImplementation() );
				Buff.setOptionalCsDb2LUWTableUsing( createdBuff.getOptionalCsDb2LUWTableUsing() );
				Buff.setOptionalCsDb2LUWTableMembers( createdBuff.getOptionalCsDb2LUWTableMembers() );
				Buff.setOptionalCsDb2LUWTableImplementation( createdBuff.getOptionalCsDb2LUWTableImplementation() );
				Buff.setOptionalCsMSSqlTableUsing( createdBuff.getOptionalCsMSSqlTableUsing() );
				Buff.setOptionalCsMSSqlTableMembers( createdBuff.getOptionalCsMSSqlTableMembers() );
				Buff.setOptionalCsMSSqlTableImplementation( createdBuff.getOptionalCsMSSqlTableImplementation() );
				Buff.setOptionalCsMySqlTableUsing( createdBuff.getOptionalCsMySqlTableUsing() );
				Buff.setOptionalCsMySqlTableMembers( createdBuff.getOptionalCsMySqlTableMembers() );
				Buff.setOptionalCsMySqlTableImplementation( createdBuff.getOptionalCsMySqlTableImplementation() );
				Buff.setOptionalCsOracleTableUsing( createdBuff.getOptionalCsOracleTableUsing() );
				Buff.setOptionalCsOracleTableMembers( createdBuff.getOptionalCsOracleTableMembers() );
				Buff.setOptionalCsOracleTableImplementation( createdBuff.getOptionalCsOracleTableImplementation() );
				Buff.setOptionalCsPgSqlTableUsing( createdBuff.getOptionalCsPgSqlTableUsing() );
				Buff.setOptionalCsPgSqlTableMembers( createdBuff.getOptionalCsPgSqlTableMembers() );
				Buff.setOptionalCsPgSqlTableImplementation( createdBuff.getOptionalCsPgSqlTableImplementation() );
				Buff.setOptionalCsRamTableUsing( createdBuff.getOptionalCsRamTableUsing() );
				Buff.setOptionalCsRamTableMembers( createdBuff.getOptionalCsRamTableMembers() );
				Buff.setOptionalCsRamTableImplementation( createdBuff.getOptionalCsRamTableImplementation() );
				Buff.setOptionalCsSaxLoaderUsing( createdBuff.getOptionalCsSaxLoaderUsing() );
				Buff.setOptionalCsSaxLoaderStartElement( createdBuff.getOptionalCsSaxLoaderStartElement() );
				Buff.setOptionalCsSaxLoaderEndElement( createdBuff.getOptionalCsSaxLoaderEndElement() );
				Buff.setOptionalCsXMsgTableUsing( createdBuff.getOptionalCsXMsgTableUsing() );
				Buff.setOptionalCsXMsgTableFormatters( createdBuff.getOptionalCsXMsgTableFormatters() );
				Buff.setOptionalCsXMsgRqstTableUsing( createdBuff.getOptionalCsXMsgRqstTableUsing() );
				Buff.setOptionalCsXMsgRspnTableUsing( createdBuff.getOptionalCsXMsgRspnTableUsing() );
				Buff.setOptionalCsXMsgClientTableUsing( createdBuff.getOptionalCsXMsgClientTableUsing() );
				Buff.setOptionalCsXMsgRqstTableBody( createdBuff.getOptionalCsXMsgRqstTableBody() );
				Buff.setOptionalCsXMsgRspnTableBody( createdBuff.getOptionalCsXMsgRspnTableBody() );
				Buff.setOptionalCsXMsgClientTableBody( createdBuff.getOptionalCsXMsgClientTableBody() );
				}
				else {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Expected a single-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			catch( SQLException e ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"crt_tbldef() did not return a valid result set" );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtCreateByPKey != null ) {
				try {
					stmtCreateByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtCreateByPKey = null;
			}
		}
	}

	protected static String S_sqlSelectTableDistinctClassCode = null;

	public String getSqlSelectTableDistinctClassCode() {
		if( S_sqlSelectTableDistinctClassCode == null ) {
			S_sqlSelectTableDistinctClassCode =
					"SELECT "
				+		"DISTINCT a801.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".scopedef a801 "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".tbldef a808 ON "
				+		"a808.TenantId = a801.TenantId "
				+		"AND a808.Id = a801.Id ";
		}
		return( S_sqlSelectTableDistinctClassCode );
	}

	protected static String S_sqlSelectTableBuff = null;

	public String getSqlSelectTableBuff() {
		if( S_sqlSelectTableBuff == null ) {
			S_sqlSelectTableBuff =
					"SELECT "
				+		"a801.ClassCode, "
				+		"a801.TenantId, "
				+		"a801.Id, "
				+		"a808.SchemaDefId, "
				+		"a808.defschtentid, "
				+		"a808.defschid, "
				+		"a808.safe_name, "
				+		"a808.DbName, "
				+		"a808.short_name, "
				+		"a808.Label, "
				+		"a808.short_descr, "
				+		"a808.descr, "
				+		"a808.PageData, "
				+		"a808.PrimIdxTentId, "
				+		"a808.PrimIdxId, "
				+		"a808.TblClsCd, "
				+		"a808.LookIdxTentId, "
				+		"a808.LookIdxId, "
				+		"a808.AltIdxTentId, "
				+		"a808.AltIdxId, "
				+		"a808.QualTentId, "
				+		"a808.QualTblId, "
				+		"a808.IsInstantiable, "
				+		"a808.HasHistory, "
				+		"a808.HasAuditColumns, "
				+		"a808.IsMutable, "
				+		"a808.IsServerOnly, "
				+		"a808.LoadBehavId, "
				+		"a808.SecScopeId, "
				+		"a808.jobj_memb, "
				+		"a808.jobj_xface, "
				+		"a808.jobj_objimp, "
				+		"a808.jobj_impl, "
				+		"a808.jedt_memb, "
				+		"a808.jedt_xface, "
				+		"a808.jtbl_eobjimp, "
				+		"a808.jedt_impl, "
				+		"a808.jtbl_imp, "
				+		"a808.jtbl_memb, "
				+		"a808.jtbl_xface, "
				+		"a808.jtbl_impl, "
				+		"a808.jtbl_objimp, "
				+		"a808.jtbl_objmemb, "
				+		"a808.jtbl_objxface, "
				+		"a808.jtbl_objimpl, "
				+		"a808.jtbl_db2imp, "
				+		"a808.jdb2_memb, "
				+		"a808.jdb2_impl, "
				+		"a808.jtbl_msimp, "
				+		"a808.jmssql_memb, "
				+		"a808.jmssql_impl, "
				+		"a808.jtbl_myimp, "
				+		"a808.jmysql_memb, "
				+		"a808.jmysql_impl, "
				+		"a808.jtbl_oraimp, "
				+		"a808.joracle_memb, "
				+		"a808.joracle_impl, "
				+		"a808.jtbl_pgimp, "
				+		"a808.jpgsql_memb, "
				+		"a808.jpgsql_impl, "
				+		"a808.jtbl_ramimp, "
				+		"a808.jram_memb, "
				+		"a808.jram_timpl, "
				+		"a808.jtbl_saxldimp, "
				+		"a808.jsaxstart_memb, "
				+		"a808.jsaxend_impl, "
				+		"a808.jxmtbl_imp, "
				+		"a808.jxmtbl_fmt, "
				+		"a808.jxmtbl_rqstimp, "
				+		"a808.jxmtbl_rspnimp, "
				+		"a808.jxmtbl_clntimp, "
				+		"a808.jxmtbl_rqstbdy, "
				+		"a808.jxmtbl_rspnbdy, "
				+		"a808.jxmtbl_clntbdy, "
				+		"a808.cppobj_memb, "
				+		"a808.cppobj_xface, "
				+		"a808.cppobj_objinc, "
				+		"a808.cppobj_incl, "
				+		"a808.cppedt_memb, "
				+		"a808.cppedt_xface, "
				+		"a808.cpptbl_eobjinc, "
				+		"a808.cppedt_incl, "
				+		"a808.cpptbl_inc, "
				+		"a808.cpptbl_memb, "
				+		"a808.cpptbl_xface, "
				+		"a808.cpptbl_incl, "
				+		"a808.cpptbl_objinc, "
				+		"a808.cpptbl_objmemb, "
				+		"a808.cpptbl_objxface, "
				+		"a808.cpptbl_objimpl, "
				+		"a808.cpptbl_db2inc, "
				+		"a808.cppdb2_memb, "
				+		"a808.cppdb2_incl, "
				+		"a808.cpptbl_msinc, "
				+		"a808.cppmssql_memb, "
				+		"a808.cppmssql_incl, "
				+		"a808.cpptbl_myinc, "
				+		"a808.cppmysql_memb, "
				+		"a808.cppmysql_incl, "
				+		"a808.cpptbl_orainc, "
				+		"a808.cpporacle_memb, "
				+		"a808.cpporacle_incl, "
				+		"a808.cpptbl_pginc, "
				+		"a808.cpppgsql_memb, "
				+		"a808.cpppgsql_incl, "
				+		"a808.cpptbl_raminc, "
				+		"a808.cppram_memb, "
				+		"a808.cppram_tincl, "
				+		"a808.cpptbl_saxldinc, "
				+		"a808.cppsaxstart_memb, "
				+		"a808.cppsaxend_incl, "
				+		"a808.cppxmtbl_inc, "
				+		"a808.cppxmtbl_fmt, "
				+		"a808.cppxmtbl_rqstinc, "
				+		"a808.cppxmtbl_rspninc, "
				+		"a808.cppxmtbl_clntinc, "
				+		"a808.cppxmtbl_rqstbdy, "
				+		"a808.cppxmtbl_rspnbdy, "
				+		"a808.cppxmtbl_clntbdy, "
				+		"a808.hppobj_memb, "
				+		"a808.hppobj_xface, "
				+		"a808.hppobj_objinc, "
				+		"a808.hppobj_incl, "
				+		"a808.hppedt_memb, "
				+		"a808.hppedt_xface, "
				+		"a808.hpptbl_eobjinc, "
				+		"a808.hppedt_incl, "
				+		"a808.hpptbl_inc, "
				+		"a808.hpptbl_memb, "
				+		"a808.hpptbl_xface, "
				+		"a808.hpptbl_incl, "
				+		"a808.hpptbl_objinc, "
				+		"a808.hpptbl_objmemb, "
				+		"a808.hpptbl_objxface, "
				+		"a808.hpptbl_objimpl, "
				+		"a808.hpptbl_db2inc, "
				+		"a808.hppdb2_memb, "
				+		"a808.hppdb2_incl, "
				+		"a808.hpptbl_msinc, "
				+		"a808.hppmssql_memb, "
				+		"a808.hppmssql_incl, "
				+		"a808.hpptbl_myinc, "
				+		"a808.hppmysql_memb, "
				+		"a808.hppmysql_incl, "
				+		"a808.hpptbl_orainc, "
				+		"a808.hpporacle_memb, "
				+		"a808.hpporacle_incl, "
				+		"a808.hpptbl_pginc, "
				+		"a808.hpppgsql_memb, "
				+		"a808.hpppgsql_incl, "
				+		"a808.hpptbl_raminc, "
				+		"a808.hppram_memb, "
				+		"a808.hppram_tincl, "
				+		"a808.hpptbl_saxldinc, "
				+		"a808.hppsaxstart_memb, "
				+		"a808.hppsaxend_incl, "
				+		"a808.hppxmtbl_inc, "
				+		"a808.hppxmtbl_fmt, "
				+		"a808.hppxmtbl_rqstinc, "
				+		"a808.hppxmtbl_rspninc, "
				+		"a808.hppxmtbl_clntinc, "
				+		"a808.hppxmtbl_rqstbdy, "
				+		"a808.hppxmtbl_rspnbdy, "
				+		"a808.hppxmtbl_clntbdy, "
				+		"a808.csobj_memb, "
				+		"a808.csobj_xface, "
				+		"a808.csobj_objinc, "
				+		"a808.csobj_incl, "
				+		"a808.csedt_memb, "
				+		"a808.csedt_xface, "
				+		"a808.cstbl_eobjinc, "
				+		"a808.csedt_incl, "
				+		"a808.cstbl_inc, "
				+		"a808.cstbl_memb, "
				+		"a808.cstbl_xface, "
				+		"a808.cstbl_incl, "
				+		"a808.cstbl_objinc, "
				+		"a808.cstbl_objmemb, "
				+		"a808.cstbl_objxface, "
				+		"a808.cstbl_objimpl, "
				+		"a808.cstbl_db2inc, "
				+		"a808.csdb2_memb, "
				+		"a808.csdb2_incl, "
				+		"a808.cstbl_msinc, "
				+		"a808.csmssql_memb, "
				+		"a808.csmssql_incl, "
				+		"a808.cstbl_myinc, "
				+		"a808.csmysql_memb, "
				+		"a808.csmysql_incl, "
				+		"a808.cstbl_orainc, "
				+		"a808.csoracle_memb, "
				+		"a808.csoracle_incl, "
				+		"a808.cstbl_pginc, "
				+		"a808.cspgsql_memb, "
				+		"a808.cspgsql_incl, "
				+		"a808.cstbl_raminc, "
				+		"a808.csram_memb, "
				+		"a808.csram_tincl, "
				+		"a808.cstbl_saxldinc, "
				+		"a808.cssaxstart_memb, "
				+		"a808.cssaxend_incl, "
				+		"a808.csxmtbl_inc, "
				+		"a808.csxmtbl_fmt, "
				+		"a808.csxmtbl_rqstinc, "
				+		"a808.csxmtbl_rspninc, "
				+		"a808.csxmtbl_clntinc, "
				+		"a808.csxmtbl_rqstbdy, "
				+		"a808.csxmtbl_rspnbdy, "
				+		"a808.csxmtbl_clntbdy, "
				+		"a801.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".scopedef a801 "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".tbldef a808 ON "
				+		"a808.TenantId = a801.TenantId "
				+		"AND a808.Id = a801.Id ";
		}
		return( S_sqlSelectTableBuff );
	}

	protected CFBamTableBuff unpackTableResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackTableResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamTableBuff buff;
		if( classCode.equals( "a808" ) ) {
			buff = schema.getFactoryTable().newBuff();
		}
		else {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Unrecognized class code \"" + classCode + "\"" );
		}
		{
			String colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setCreatedByUserId( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setCreatedByUserId( null );
			}
			else {
				buff.setCreatedByUserId( UUID.fromString( colString ) );
			}
			idxcol ++;

			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setCreatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setCreatedAt( null );
			}
			else {
				buff.setCreatedAt( CFBamOracleSchema.convertTimestampString( colString ) );
			}
			idxcol++;
			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedByUserId( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedByUserId( null );
			}
			else {
				buff.setUpdatedByUserId( UUID.fromString( colString ) );
			}
			idxcol ++;

			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedAt( null );
			}
			else {
				buff.setUpdatedAt( CFBamOracleSchema.convertTimestampString( colString ) );
			}
			idxcol++;
		}
		buff.setRequiredTenantId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredSchemaDefId( resultSet.getLong( idxcol ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefSchemaTenantId( null );
			}
			else {
				buff.setOptionalDefSchemaTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefSchemaId( null );
			}
			else {
				buff.setOptionalDefSchemaId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredName( resultSet.getString( idxcol ) );
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDbName( null );
			}
			else {
				buff.setOptionalDbName( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalShortName( null );
			}
			else {
				buff.setOptionalShortName( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalLabel( null );
			}
			else {
				buff.setOptionalLabel( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalShortDescription( null );
			}
			else {
				buff.setOptionalShortDescription( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDescription( null );
			}
			else {
				buff.setOptionalDescription( colVal );
			}
		}
		idxcol++;
		buff.setRequiredPageData( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalPrimaryIndexTenantId( null );
			}
			else {
				buff.setOptionalPrimaryIndexTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalPrimaryIndexId( null );
			}
			else {
				buff.setOptionalPrimaryIndexId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredTableClassCode( resultSet.getString( idxcol ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalLookupIndexTenantId( null );
			}
			else {
				buff.setOptionalLookupIndexTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalLookupIndexId( null );
			}
			else {
				buff.setOptionalLookupIndexId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalAltIndexTenantId( null );
			}
			else {
				buff.setOptionalAltIndexTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalAltIndexId( null );
			}
			else {
				buff.setOptionalAltIndexId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalQualifyingTenantId( null );
			}
			else {
				buff.setOptionalQualifyingTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalQualifyingTableId( null );
			}
			else {
				buff.setOptionalQualifyingTableId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredIsInstantiable( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredHasHistory( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredHasAuditColumns( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredIsMutable( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredIsServerOnly( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		buff.setRequiredLoaderBehaviour( CFBamSchema.ordinalToLoaderBehaviourEnum( resultSet.getShort( idxcol ) ) );
		idxcol++;
		buff.setRequiredSecScope( CFBamSchema.ordinalToSecScopeEnum( resultSet.getShort( idxcol ) ) );
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJObjMembers( null );
			}
			else {
				buff.setOptionalJObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJObjInterface( null );
			}
			else {
				buff.setOptionalJObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJObjImport( null );
			}
			else {
				buff.setOptionalJObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJObjImplementation( null );
			}
			else {
				buff.setOptionalJObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJEditObjMembers( null );
			}
			else {
				buff.setOptionalJEditObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJEditObjInterface( null );
			}
			else {
				buff.setOptionalJEditObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJEditObjImport( null );
			}
			else {
				buff.setOptionalJEditObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJEditObjImplementation( null );
			}
			else {
				buff.setOptionalJEditObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableImport( null );
			}
			else {
				buff.setOptionalJTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableMembers( null );
			}
			else {
				buff.setOptionalJTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableInterface( null );
			}
			else {
				buff.setOptionalJTableInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableImplementation( null );
			}
			else {
				buff.setOptionalJTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableObjImport( null );
			}
			else {
				buff.setOptionalJTableObjImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableObjMembers( null );
			}
			else {
				buff.setOptionalJTableObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableObjInterface( null );
			}
			else {
				buff.setOptionalJTableObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJTableObjImplementation( null );
			}
			else {
				buff.setOptionalJTableObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJDb2LUWTableImport( null );
			}
			else {
				buff.setOptionalJDb2LUWTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJDb2LUWTableMembers( null );
			}
			else {
				buff.setOptionalJDb2LUWTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJDb2LUWTableImplementation( null );
			}
			else {
				buff.setOptionalJDb2LUWTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMSSqlTableImport( null );
			}
			else {
				buff.setOptionalJMSSqlTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMSSqlTableMembers( null );
			}
			else {
				buff.setOptionalJMSSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMSSqlTableImplementation( null );
			}
			else {
				buff.setOptionalJMSSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMySqlTableImport( null );
			}
			else {
				buff.setOptionalJMySqlTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMySqlTableMembers( null );
			}
			else {
				buff.setOptionalJMySqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJMySqlTableImplementation( null );
			}
			else {
				buff.setOptionalJMySqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJOracleTableImport( null );
			}
			else {
				buff.setOptionalJOracleTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJOracleTableMembers( null );
			}
			else {
				buff.setOptionalJOracleTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJOracleTableImplementation( null );
			}
			else {
				buff.setOptionalJOracleTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJPgSqlTableImport( null );
			}
			else {
				buff.setOptionalJPgSqlTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJPgSqlTableMembers( null );
			}
			else {
				buff.setOptionalJPgSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJPgSqlTableImplementation( null );
			}
			else {
				buff.setOptionalJPgSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJRamTableImport( null );
			}
			else {
				buff.setOptionalJRamTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJRamTableMembers( null );
			}
			else {
				buff.setOptionalJRamTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJRamTableImplementation( null );
			}
			else {
				buff.setOptionalJRamTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSaxLoaderImport( null );
			}
			else {
				buff.setOptionalJSaxLoaderImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSaxLoaderStartElement( null );
			}
			else {
				buff.setOptionalJSaxLoaderStartElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJSaxLoaderEndElement( null );
			}
			else {
				buff.setOptionalJSaxLoaderEndElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgTableImport( null );
			}
			else {
				buff.setOptionalJXMsgTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgTableFormatters( null );
			}
			else {
				buff.setOptionalJXMsgTableFormatters( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRqstTableImport( null );
			}
			else {
				buff.setOptionalJXMsgRqstTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRspnTableImport( null );
			}
			else {
				buff.setOptionalJXMsgRspnTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgClientTableImport( null );
			}
			else {
				buff.setOptionalJXMsgClientTableImport( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRqstTableBody( null );
			}
			else {
				buff.setOptionalJXMsgRqstTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgRspnTableBody( null );
			}
			else {
				buff.setOptionalJXMsgRspnTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalJXMsgClientTableBody( null );
			}
			else {
				buff.setOptionalJXMsgClientTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppObjMembers( null );
			}
			else {
				buff.setOptionalCppObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppObjInterface( null );
			}
			else {
				buff.setOptionalCppObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppObjInclude( null );
			}
			else {
				buff.setOptionalCppObjInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppObjImplementation( null );
			}
			else {
				buff.setOptionalCppObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppEditObjMembers( null );
			}
			else {
				buff.setOptionalCppEditObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppEditObjInterface( null );
			}
			else {
				buff.setOptionalCppEditObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppEditObjInclude( null );
			}
			else {
				buff.setOptionalCppEditObjInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppEditObjImplementation( null );
			}
			else {
				buff.setOptionalCppEditObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppTableInclude( null );
			}
			else {
				buff.setOptionalCppTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppTableMembers( null );
			}
			else {
				buff.setOptionalCppTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppTableInterface( null );
			}
			else {
				buff.setOptionalCppTableInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppTableImplementation( null );
			}
			else {
				buff.setOptionalCppTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppTableObjInclude( null );
			}
			else {
				buff.setOptionalCppTableObjInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppTableObjMembers( null );
			}
			else {
				buff.setOptionalCppTableObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppTableObjInterface( null );
			}
			else {
				buff.setOptionalCppTableObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppTableObjImplementation( null );
			}
			else {
				buff.setOptionalCppTableObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppDb2LUWTableInclude( null );
			}
			else {
				buff.setOptionalCppDb2LUWTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppDb2LUWTableMembers( null );
			}
			else {
				buff.setOptionalCppDb2LUWTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppDb2LUWTableImplementation( null );
			}
			else {
				buff.setOptionalCppDb2LUWTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppMSSqlTableInclude( null );
			}
			else {
				buff.setOptionalCppMSSqlTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppMSSqlTableMembers( null );
			}
			else {
				buff.setOptionalCppMSSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppMSSqlTableImplementation( null );
			}
			else {
				buff.setOptionalCppMSSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppMySqlTableInclude( null );
			}
			else {
				buff.setOptionalCppMySqlTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppMySqlTableMembers( null );
			}
			else {
				buff.setOptionalCppMySqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppMySqlTableImplementation( null );
			}
			else {
				buff.setOptionalCppMySqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppOracleTableInclude( null );
			}
			else {
				buff.setOptionalCppOracleTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppOracleTableMembers( null );
			}
			else {
				buff.setOptionalCppOracleTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppOracleTableImplementation( null );
			}
			else {
				buff.setOptionalCppOracleTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppPgSqlTableInclude( null );
			}
			else {
				buff.setOptionalCppPgSqlTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppPgSqlTableMembers( null );
			}
			else {
				buff.setOptionalCppPgSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppPgSqlTableImplementation( null );
			}
			else {
				buff.setOptionalCppPgSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppRamTableInclude( null );
			}
			else {
				buff.setOptionalCppRamTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppRamTableMembers( null );
			}
			else {
				buff.setOptionalCppRamTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppRamTableImplementation( null );
			}
			else {
				buff.setOptionalCppRamTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppSaxLoaderInclude( null );
			}
			else {
				buff.setOptionalCppSaxLoaderInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppSaxLoaderStartElement( null );
			}
			else {
				buff.setOptionalCppSaxLoaderStartElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppSaxLoaderEndElement( null );
			}
			else {
				buff.setOptionalCppSaxLoaderEndElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppXMsgTableInclude( null );
			}
			else {
				buff.setOptionalCppXMsgTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppXMsgTableFormatters( null );
			}
			else {
				buff.setOptionalCppXMsgTableFormatters( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppXMsgRqstTableInclude( null );
			}
			else {
				buff.setOptionalCppXMsgRqstTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppXMsgRspnTableInclude( null );
			}
			else {
				buff.setOptionalCppXMsgRspnTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppXMsgClientTableInclude( null );
			}
			else {
				buff.setOptionalCppXMsgClientTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppXMsgRqstTableBody( null );
			}
			else {
				buff.setOptionalCppXMsgRqstTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppXMsgRspnTableBody( null );
			}
			else {
				buff.setOptionalCppXMsgRspnTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCppXMsgClientTableBody( null );
			}
			else {
				buff.setOptionalCppXMsgClientTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppObjMembers( null );
			}
			else {
				buff.setOptionalHppObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppObjInterface( null );
			}
			else {
				buff.setOptionalHppObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppObjInclude( null );
			}
			else {
				buff.setOptionalHppObjInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppObjImplementation( null );
			}
			else {
				buff.setOptionalHppObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppEditObjMembers( null );
			}
			else {
				buff.setOptionalHppEditObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppEditObjInterface( null );
			}
			else {
				buff.setOptionalHppEditObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppEditObjInclude( null );
			}
			else {
				buff.setOptionalHppEditObjInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppEditObjImplementation( null );
			}
			else {
				buff.setOptionalHppEditObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppTableInclude( null );
			}
			else {
				buff.setOptionalHppTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppTableMembers( null );
			}
			else {
				buff.setOptionalHppTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppTableInterface( null );
			}
			else {
				buff.setOptionalHppTableInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppTableImplementation( null );
			}
			else {
				buff.setOptionalHppTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppTableObjInclude( null );
			}
			else {
				buff.setOptionalHppTableObjInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppTableObjMembers( null );
			}
			else {
				buff.setOptionalHppTableObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppTableObjInterface( null );
			}
			else {
				buff.setOptionalHppTableObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppTableObjImplementation( null );
			}
			else {
				buff.setOptionalHppTableObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppDb2LUWTableInclude( null );
			}
			else {
				buff.setOptionalHppDb2LUWTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppDb2LUWTableMembers( null );
			}
			else {
				buff.setOptionalHppDb2LUWTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppDb2LUWTableImplementation( null );
			}
			else {
				buff.setOptionalHppDb2LUWTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppMSSqlTableInclude( null );
			}
			else {
				buff.setOptionalHppMSSqlTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppMSSqlTableMembers( null );
			}
			else {
				buff.setOptionalHppMSSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppMSSqlTableImplementation( null );
			}
			else {
				buff.setOptionalHppMSSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppMySqlTableInclude( null );
			}
			else {
				buff.setOptionalHppMySqlTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppMySqlTableMembers( null );
			}
			else {
				buff.setOptionalHppMySqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppMySqlTableImplementation( null );
			}
			else {
				buff.setOptionalHppMySqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppOracleTableInclude( null );
			}
			else {
				buff.setOptionalHppOracleTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppOracleTableMembers( null );
			}
			else {
				buff.setOptionalHppOracleTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppOracleTableImplementation( null );
			}
			else {
				buff.setOptionalHppOracleTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppPgSqlTableInclude( null );
			}
			else {
				buff.setOptionalHppPgSqlTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppPgSqlTableMembers( null );
			}
			else {
				buff.setOptionalHppPgSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppPgSqlTableImplementation( null );
			}
			else {
				buff.setOptionalHppPgSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppRamTableInclude( null );
			}
			else {
				buff.setOptionalHppRamTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppRamTableMembers( null );
			}
			else {
				buff.setOptionalHppRamTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppRamTableImplementation( null );
			}
			else {
				buff.setOptionalHppRamTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppSaxLoaderInclude( null );
			}
			else {
				buff.setOptionalHppSaxLoaderInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppSaxLoaderStartElement( null );
			}
			else {
				buff.setOptionalHppSaxLoaderStartElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppSaxLoaderEndElement( null );
			}
			else {
				buff.setOptionalHppSaxLoaderEndElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppXMsgTableInclude( null );
			}
			else {
				buff.setOptionalHppXMsgTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppXMsgTableFormatters( null );
			}
			else {
				buff.setOptionalHppXMsgTableFormatters( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppXMsgRqstTableInclude( null );
			}
			else {
				buff.setOptionalHppXMsgRqstTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppXMsgRspnTableInclude( null );
			}
			else {
				buff.setOptionalHppXMsgRspnTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppXMsgClientTableInclude( null );
			}
			else {
				buff.setOptionalHppXMsgClientTableInclude( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppXMsgRqstTableBody( null );
			}
			else {
				buff.setOptionalHppXMsgRqstTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppXMsgRspnTableBody( null );
			}
			else {
				buff.setOptionalHppXMsgRspnTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalHppXMsgClientTableBody( null );
			}
			else {
				buff.setOptionalHppXMsgClientTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsObjMembers( null );
			}
			else {
				buff.setOptionalCsObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsObjInterface( null );
			}
			else {
				buff.setOptionalCsObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsObjUsing( null );
			}
			else {
				buff.setOptionalCsObjUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsObjImplementation( null );
			}
			else {
				buff.setOptionalCsObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsEditObjMembers( null );
			}
			else {
				buff.setOptionalCsEditObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsEditObjInterface( null );
			}
			else {
				buff.setOptionalCsEditObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsEditObjUsing( null );
			}
			else {
				buff.setOptionalCsEditObjUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsEditObjImplementation( null );
			}
			else {
				buff.setOptionalCsEditObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsTableUsing( null );
			}
			else {
				buff.setOptionalCsTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsTableMembers( null );
			}
			else {
				buff.setOptionalCsTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsTableInterface( null );
			}
			else {
				buff.setOptionalCsTableInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsTableImplementation( null );
			}
			else {
				buff.setOptionalCsTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsTableObjUsing( null );
			}
			else {
				buff.setOptionalCsTableObjUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsTableObjMembers( null );
			}
			else {
				buff.setOptionalCsTableObjMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsTableObjInterface( null );
			}
			else {
				buff.setOptionalCsTableObjInterface( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsTableObjImplementation( null );
			}
			else {
				buff.setOptionalCsTableObjImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsDb2LUWTableUsing( null );
			}
			else {
				buff.setOptionalCsDb2LUWTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsDb2LUWTableMembers( null );
			}
			else {
				buff.setOptionalCsDb2LUWTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsDb2LUWTableImplementation( null );
			}
			else {
				buff.setOptionalCsDb2LUWTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsMSSqlTableUsing( null );
			}
			else {
				buff.setOptionalCsMSSqlTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsMSSqlTableMembers( null );
			}
			else {
				buff.setOptionalCsMSSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsMSSqlTableImplementation( null );
			}
			else {
				buff.setOptionalCsMSSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsMySqlTableUsing( null );
			}
			else {
				buff.setOptionalCsMySqlTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsMySqlTableMembers( null );
			}
			else {
				buff.setOptionalCsMySqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsMySqlTableImplementation( null );
			}
			else {
				buff.setOptionalCsMySqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsOracleTableUsing( null );
			}
			else {
				buff.setOptionalCsOracleTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsOracleTableMembers( null );
			}
			else {
				buff.setOptionalCsOracleTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsOracleTableImplementation( null );
			}
			else {
				buff.setOptionalCsOracleTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsPgSqlTableUsing( null );
			}
			else {
				buff.setOptionalCsPgSqlTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsPgSqlTableMembers( null );
			}
			else {
				buff.setOptionalCsPgSqlTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsPgSqlTableImplementation( null );
			}
			else {
				buff.setOptionalCsPgSqlTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsRamTableUsing( null );
			}
			else {
				buff.setOptionalCsRamTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsRamTableMembers( null );
			}
			else {
				buff.setOptionalCsRamTableMembers( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsRamTableImplementation( null );
			}
			else {
				buff.setOptionalCsRamTableImplementation( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsSaxLoaderUsing( null );
			}
			else {
				buff.setOptionalCsSaxLoaderUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsSaxLoaderStartElement( null );
			}
			else {
				buff.setOptionalCsSaxLoaderStartElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsSaxLoaderEndElement( null );
			}
			else {
				buff.setOptionalCsSaxLoaderEndElement( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsXMsgTableUsing( null );
			}
			else {
				buff.setOptionalCsXMsgTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsXMsgTableFormatters( null );
			}
			else {
				buff.setOptionalCsXMsgTableFormatters( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsXMsgRqstTableUsing( null );
			}
			else {
				buff.setOptionalCsXMsgRqstTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsXMsgRspnTableUsing( null );
			}
			else {
				buff.setOptionalCsXMsgRspnTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsXMsgClientTableUsing( null );
			}
			else {
				buff.setOptionalCsXMsgClientTableUsing( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsXMsgRqstTableBody( null );
			}
			else {
				buff.setOptionalCsXMsgRqstTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsXMsgRspnTableBody( null );
			}
			else {
				buff.setOptionalCsXMsgRspnTableBody( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalCsXMsgClientTableBody( null );
			}
			else {
				buff.setOptionalCsXMsgClientTableBody( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamTableBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamTableBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamTableBuff[] readAllDerived( CFSecAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamTableBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamTableBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamOracleTableTable.readDerivedByIdIdx() ";
		CFBamTableBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		return( buff );
	}

	public CFBamTableBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedBySchemaDefIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		final String S_ProcName = "readDerivedBySchemaDefIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffBySchemaDefIdx( Authorization,
				TenantId,
				SchemaDefId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByDefSchemaIdx( Authorization,
				DefSchemaTenantId,
				DefSchemaId );
		return( buffList );

	}

	public CFBamTableBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String Name )
	{
		final String S_ProcName = "CFBamOracleTableTable.readDerivedByUNameIdx() ";
		CFBamTableBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				TenantId,
				SchemaDefId,
				Name );
		return( buff );
	}

	public CFBamTableBuff readDerivedBySchemaCdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		final String S_ProcName = "CFBamOracleTableTable.readDerivedBySchemaCdIdx() ";
		CFBamTableBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffBySchemaCdIdx( Authorization,
				TenantId,
				SchemaDefId,
				TableClassCode );
		return( buff );
	}

	public CFBamTableBuff[] readDerivedByPrimaryIndexIdx( CFSecAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		final String S_ProcName = "readDerivedByPrimaryIndexIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByPrimaryIndexIdx( Authorization,
				PrimaryIndexTenantId,
				PrimaryIndexId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByLookupIndexIdx( CFSecAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		final String S_ProcName = "readDerivedByLookupIndexIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByLookupIndexIdx( Authorization,
				LookupIndexTenantId,
				LookupIndexId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByAltIndexIdx( CFSecAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId )
	{
		final String S_ProcName = "readDerivedByAltIndexIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByAltIndexIdx( Authorization,
				AltIndexTenantId,
				AltIndexId );
		return( buffList );

	}

	public CFBamTableBuff[] readDerivedByQualTableIdx( CFSecAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		final String S_ProcName = "readDerivedByQualTableIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamTableBuff[] buffList = readBuffByQualTableIdx( Authorization,
				QualifyingTenantId,
				QualifyingTableId );
		return( buffList );

	}

	public CFBamTableBuff readBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readBuff";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByPKey = null;
		try {
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldef( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPKey.setLong( argIdx++, TenantId );
			stmtReadBuffByPKey.setLong( argIdx++, Id );
			stmtReadBuffByPKey.execute();
			resultSet = (ResultSet)stmtReadBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByPKey != null ) {
				try {
					stmtReadBuffByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByPKey = null;
			}
		}
	}

	public CFBamTableBuff lockBuff( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockBuff";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtLockBuffByPKey = null;
		try {
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_tbldef( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtLockBuffByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockBuffByPKey.setLong( argIdx++, TenantId );
			stmtLockBuffByPKey.setLong( argIdx++, Id );
			stmtLockBuffByPKey.execute();
			resultSet = (ResultSet)stmtLockBuffByPKey.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtLockBuffByPKey != null ) {
				try {
					stmtLockBuffByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtLockBuffByPKey = null;
			}
		}
	}

	public CFBamTableBuff[] readAllBuff( CFSecAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadAllBuff = null;
		try {
			CFBamTableBuff buff = null;
			List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefall( ?, ?, ?, ?, ?, ? ) ); end;" );
			int argIdx = 1;
			stmtReadAllBuff.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadAllBuff.execute();
			resultSet = (ResultSet)stmtReadAllBuff.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						buff = unpackTableResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadAllBuff != null ) {
				try {
					stmtReadAllBuff.close();
				}
				catch( SQLException e ) {
				}
				stmtReadAllBuff = null;
			}
		}
	}

	public CFBamTableBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbyididx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByIdIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByIdIdx.setLong( argIdx++, Id );
			stmtReadBuffByIdIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByIdIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByIdIdx != null ) {
				try {
					stmtReadBuffByIdIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByIdIdx = null;
			}
		}
	}

	public CFBamTableBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByTenantIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByTenantIdx = null;
		List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
		try {
			stmtReadBuffByTenantIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbytenantidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByTenantIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByTenantIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByTenantIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByTenantIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByTenantIdx != null ) {
				try {
					stmtReadBuffByTenantIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByTenantIdx = null;
			}
		}
	}

	public CFBamTableBuff[] readBuffBySchemaDefIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId )
	{
		final String S_ProcName = "readBuffBySchemaDefIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffBySchemaDefIdx = null;
		List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
		try {
			stmtReadBuffBySchemaDefIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbyschemadefidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffBySchemaDefIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaDefIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffBySchemaDefIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, TenantId );
			stmtReadBuffBySchemaDefIdx.setLong( argIdx++, SchemaDefId );
			stmtReadBuffBySchemaDefIdx.execute();
			resultSet = (ResultSet)stmtReadBuffBySchemaDefIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffBySchemaDefIdx != null ) {
				try {
					stmtReadBuffBySchemaDefIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffBySchemaDefIdx = null;
			}
		}
	}

	public CFBamTableBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readBuffByDefSchemaIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByDefSchemaIdx = null;
		List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
		try {
			stmtReadBuffByDefSchemaIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbydefschemaidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByDefSchemaIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DefSchemaTenantId != null ) {
				stmtReadBuffByDefSchemaIdx.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtReadBuffByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtReadBuffByDefSchemaIdx.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtReadBuffByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByDefSchemaIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByDefSchemaIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByDefSchemaIdx != null ) {
				try {
					stmtReadBuffByDefSchemaIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByDefSchemaIdx = null;
			}
		}
	}

	public CFBamTableBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByUNameIdx = null;
		try {
			stmtReadBuffByUNameIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbyunameidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByUNameIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByUNameIdx.setLong( argIdx++, SchemaDefId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			stmtReadBuffByUNameIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByUNameIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByUNameIdx != null ) {
				try {
					stmtReadBuffByUNameIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByUNameIdx = null;
			}
		}
	}

	public CFBamTableBuff readBuffBySchemaCdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long SchemaDefId,
		String TableClassCode )
	{
		final String S_ProcName = "readBuffBySchemaCdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffBySchemaCdIdx = null;
		try {
			stmtReadBuffBySchemaCdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbyschemacdidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffBySchemaCdIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaCdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffBySchemaCdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, TenantId );
			stmtReadBuffBySchemaCdIdx.setLong( argIdx++, SchemaDefId );
			stmtReadBuffBySchemaCdIdx.setString( argIdx++, TableClassCode );
			stmtReadBuffBySchemaCdIdx.execute();
			resultSet = (ResultSet)stmtReadBuffBySchemaCdIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
					return( buff );
				}
				else {
					return( null );
				}
			}
			catch( SQLException e ) {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffBySchemaCdIdx != null ) {
				try {
					stmtReadBuffBySchemaCdIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffBySchemaCdIdx = null;
			}
		}
	}

	public CFBamTableBuff[] readBuffByPrimaryIndexIdx( CFSecAuthorization Authorization,
		Long PrimaryIndexTenantId,
		Long PrimaryIndexId )
	{
		final String S_ProcName = "readBuffByPrimaryIndexIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByPrimaryIndexIdx = null;
		List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
		try {
			stmtReadBuffByPrimaryIndexIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbyprimaryindexidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByPrimaryIndexIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPrimaryIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPrimaryIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( PrimaryIndexTenantId != null ) {
				stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, PrimaryIndexTenantId.longValue() );
			}
			else {
				stmtReadBuffByPrimaryIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrimaryIndexId != null ) {
				stmtReadBuffByPrimaryIndexIdx.setLong( argIdx++, PrimaryIndexId.longValue() );
			}
			else {
				stmtReadBuffByPrimaryIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByPrimaryIndexIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByPrimaryIndexIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByPrimaryIndexIdx != null ) {
				try {
					stmtReadBuffByPrimaryIndexIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByPrimaryIndexIdx = null;
			}
		}
	}

	public CFBamTableBuff[] readBuffByLookupIndexIdx( CFSecAuthorization Authorization,
		Long LookupIndexTenantId,
		Long LookupIndexId )
	{
		final String S_ProcName = "readBuffByLookupIndexIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByLookupIndexIdx = null;
		List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
		try {
			stmtReadBuffByLookupIndexIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbylookupindexidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByLookupIndexIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByLookupIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByLookupIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( LookupIndexTenantId != null ) {
				stmtReadBuffByLookupIndexIdx.setLong( argIdx++, LookupIndexTenantId.longValue() );
			}
			else {
				stmtReadBuffByLookupIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( LookupIndexId != null ) {
				stmtReadBuffByLookupIndexIdx.setLong( argIdx++, LookupIndexId.longValue() );
			}
			else {
				stmtReadBuffByLookupIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByLookupIndexIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByLookupIndexIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByLookupIndexIdx != null ) {
				try {
					stmtReadBuffByLookupIndexIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByLookupIndexIdx = null;
			}
		}
	}

	public CFBamTableBuff[] readBuffByAltIndexIdx( CFSecAuthorization Authorization,
		Long AltIndexTenantId,
		Long AltIndexId )
	{
		final String S_ProcName = "readBuffByAltIndexIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByAltIndexIdx = null;
		List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
		try {
			stmtReadBuffByAltIndexIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbyaltindexidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByAltIndexIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByAltIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByAltIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( AltIndexTenantId != null ) {
				stmtReadBuffByAltIndexIdx.setLong( argIdx++, AltIndexTenantId.longValue() );
			}
			else {
				stmtReadBuffByAltIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexId != null ) {
				stmtReadBuffByAltIndexIdx.setLong( argIdx++, AltIndexId.longValue() );
			}
			else {
				stmtReadBuffByAltIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByAltIndexIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByAltIndexIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByAltIndexIdx != null ) {
				try {
					stmtReadBuffByAltIndexIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByAltIndexIdx = null;
			}
		}
	}

	public CFBamTableBuff[] readBuffByQualTableIdx( CFSecAuthorization Authorization,
		Long QualifyingTenantId,
		Long QualifyingTableId )
	{
		final String S_ProcName = "readBuffByQualTableIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByQualTableIdx = null;
		List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
		try {
			stmtReadBuffByQualTableIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_tbldefbyqualtableidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByQualTableIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByQualTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByQualTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( QualifyingTenantId != null ) {
				stmtReadBuffByQualTableIdx.setLong( argIdx++, QualifyingTenantId.longValue() );
			}
			else {
				stmtReadBuffByQualTableIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTableId != null ) {
				stmtReadBuffByQualTableIdx.setLong( argIdx++, QualifyingTableId.longValue() );
			}
			else {
				stmtReadBuffByQualTableIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByQualTableIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByQualTableIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamTableBuff buff = unpackTableResultSetToBuff( resultSet );
						buffList.add( buff );
					}
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
				catch( SQLException e ) {
				}
			}
			int idx = 0;
			CFBamTableBuff[] retBuff = new CFBamTableBuff[ buffList.size() ];
			Iterator<CFBamTableBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtReadBuffByQualTableIdx != null ) {
				try {
					stmtReadBuffByQualTableIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByQualTableIdx = null;
			}
		}
	}

	public void updateTable( CFSecAuthorization Authorization,
		CFBamTableBuff Buff )
	{
		final String S_ProcName = "updateTable";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamTableBuff> buffList = new LinkedList<CFBamTableBuff>();
		try {			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			long SchemaDefId = Buff.getRequiredSchemaDefId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			String Name = Buff.getRequiredName();
			String DbName = Buff.getOptionalDbName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			boolean PageData = Buff.getRequiredPageData();
			Long PrimaryIndexTenantId = Buff.getOptionalPrimaryIndexTenantId();
			Long PrimaryIndexId = Buff.getOptionalPrimaryIndexId();
			String TableClassCode = Buff.getRequiredTableClassCode();
			Long LookupIndexTenantId = Buff.getOptionalLookupIndexTenantId();
			Long LookupIndexId = Buff.getOptionalLookupIndexId();
			Long AltIndexTenantId = Buff.getOptionalAltIndexTenantId();
			Long AltIndexId = Buff.getOptionalAltIndexId();
			Long QualifyingTenantId = Buff.getOptionalQualifyingTenantId();
			Long QualifyingTableId = Buff.getOptionalQualifyingTableId();
			boolean IsInstantiable = Buff.getRequiredIsInstantiable();
			boolean HasHistory = Buff.getRequiredHasHistory();
			boolean HasAuditColumns = Buff.getRequiredHasAuditColumns();
			boolean IsMutable = Buff.getRequiredIsMutable();
			boolean IsServerOnly = Buff.getRequiredIsServerOnly();
			ICFBamSchema.LoaderBehaviourEnum LoaderBehaviour = Buff.getRequiredLoaderBehaviour();
			ICFBamSchema.SecScopeEnum SecScope = Buff.getRequiredSecScope();
			String JObjMembers = Buff.getOptionalJObjMembers();
			String JObjInterface = Buff.getOptionalJObjInterface();
			String JObjImport = Buff.getOptionalJObjImport();
			String JObjImplementation = Buff.getOptionalJObjImplementation();
			String JEditObjMembers = Buff.getOptionalJEditObjMembers();
			String JEditObjInterface = Buff.getOptionalJEditObjInterface();
			String JEditObjImport = Buff.getOptionalJEditObjImport();
			String JEditObjImplementation = Buff.getOptionalJEditObjImplementation();
			String JTableImport = Buff.getOptionalJTableImport();
			String JTableMembers = Buff.getOptionalJTableMembers();
			String JTableInterface = Buff.getOptionalJTableInterface();
			String JTableImplementation = Buff.getOptionalJTableImplementation();
			String JTableObjImport = Buff.getOptionalJTableObjImport();
			String JTableObjMembers = Buff.getOptionalJTableObjMembers();
			String JTableObjInterface = Buff.getOptionalJTableObjInterface();
			String JTableObjImplementation = Buff.getOptionalJTableObjImplementation();
			String JDb2LUWTableImport = Buff.getOptionalJDb2LUWTableImport();
			String JDb2LUWTableMembers = Buff.getOptionalJDb2LUWTableMembers();
			String JDb2LUWTableImplementation = Buff.getOptionalJDb2LUWTableImplementation();
			String JMSSqlTableImport = Buff.getOptionalJMSSqlTableImport();
			String JMSSqlTableMembers = Buff.getOptionalJMSSqlTableMembers();
			String JMSSqlTableImplementation = Buff.getOptionalJMSSqlTableImplementation();
			String JMySqlTableImport = Buff.getOptionalJMySqlTableImport();
			String JMySqlTableMembers = Buff.getOptionalJMySqlTableMembers();
			String JMySqlTableImplementation = Buff.getOptionalJMySqlTableImplementation();
			String JOracleTableImport = Buff.getOptionalJOracleTableImport();
			String JOracleTableMembers = Buff.getOptionalJOracleTableMembers();
			String JOracleTableImplementation = Buff.getOptionalJOracleTableImplementation();
			String JPgSqlTableImport = Buff.getOptionalJPgSqlTableImport();
			String JPgSqlTableMembers = Buff.getOptionalJPgSqlTableMembers();
			String JPgSqlTableImplementation = Buff.getOptionalJPgSqlTableImplementation();
			String JRamTableImport = Buff.getOptionalJRamTableImport();
			String JRamTableMembers = Buff.getOptionalJRamTableMembers();
			String JRamTableImplementation = Buff.getOptionalJRamTableImplementation();
			String JSaxLoaderImport = Buff.getOptionalJSaxLoaderImport();
			String JSaxLoaderStartElement = Buff.getOptionalJSaxLoaderStartElement();
			String JSaxLoaderEndElement = Buff.getOptionalJSaxLoaderEndElement();
			String JXMsgTableImport = Buff.getOptionalJXMsgTableImport();
			String JXMsgTableFormatters = Buff.getOptionalJXMsgTableFormatters();
			String JXMsgRqstTableImport = Buff.getOptionalJXMsgRqstTableImport();
			String JXMsgRspnTableImport = Buff.getOptionalJXMsgRspnTableImport();
			String JXMsgClientTableImport = Buff.getOptionalJXMsgClientTableImport();
			String JXMsgRqstTableBody = Buff.getOptionalJXMsgRqstTableBody();
			String JXMsgRspnTableBody = Buff.getOptionalJXMsgRspnTableBody();
			String JXMsgClientTableBody = Buff.getOptionalJXMsgClientTableBody();
			String CppObjMembers = Buff.getOptionalCppObjMembers();
			String CppObjInterface = Buff.getOptionalCppObjInterface();
			String CppObjInclude = Buff.getOptionalCppObjInclude();
			String CppObjImplementation = Buff.getOptionalCppObjImplementation();
			String CppEditObjMembers = Buff.getOptionalCppEditObjMembers();
			String CppEditObjInterface = Buff.getOptionalCppEditObjInterface();
			String CppEditObjInclude = Buff.getOptionalCppEditObjInclude();
			String CppEditObjImplementation = Buff.getOptionalCppEditObjImplementation();
			String CppTableInclude = Buff.getOptionalCppTableInclude();
			String CppTableMembers = Buff.getOptionalCppTableMembers();
			String CppTableInterface = Buff.getOptionalCppTableInterface();
			String CppTableImplementation = Buff.getOptionalCppTableImplementation();
			String CppTableObjInclude = Buff.getOptionalCppTableObjInclude();
			String CppTableObjMembers = Buff.getOptionalCppTableObjMembers();
			String CppTableObjInterface = Buff.getOptionalCppTableObjInterface();
			String CppTableObjImplementation = Buff.getOptionalCppTableObjImplementation();
			String CppDb2LUWTableInclude = Buff.getOptionalCppDb2LUWTableInclude();
			String CppDb2LUWTableMembers = Buff.getOptionalCppDb2LUWTableMembers();
			String CppDb2LUWTableImplementation = Buff.getOptionalCppDb2LUWTableImplementation();
			String CppMSSqlTableInclude = Buff.getOptionalCppMSSqlTableInclude();
			String CppMSSqlTableMembers = Buff.getOptionalCppMSSqlTableMembers();
			String CppMSSqlTableImplementation = Buff.getOptionalCppMSSqlTableImplementation();
			String CppMySqlTableInclude = Buff.getOptionalCppMySqlTableInclude();
			String CppMySqlTableMembers = Buff.getOptionalCppMySqlTableMembers();
			String CppMySqlTableImplementation = Buff.getOptionalCppMySqlTableImplementation();
			String CppOracleTableInclude = Buff.getOptionalCppOracleTableInclude();
			String CppOracleTableMembers = Buff.getOptionalCppOracleTableMembers();
			String CppOracleTableImplementation = Buff.getOptionalCppOracleTableImplementation();
			String CppPgSqlTableInclude = Buff.getOptionalCppPgSqlTableInclude();
			String CppPgSqlTableMembers = Buff.getOptionalCppPgSqlTableMembers();
			String CppPgSqlTableImplementation = Buff.getOptionalCppPgSqlTableImplementation();
			String CppRamTableInclude = Buff.getOptionalCppRamTableInclude();
			String CppRamTableMembers = Buff.getOptionalCppRamTableMembers();
			String CppRamTableImplementation = Buff.getOptionalCppRamTableImplementation();
			String CppSaxLoaderInclude = Buff.getOptionalCppSaxLoaderInclude();
			String CppSaxLoaderStartElement = Buff.getOptionalCppSaxLoaderStartElement();
			String CppSaxLoaderEndElement = Buff.getOptionalCppSaxLoaderEndElement();
			String CppXMsgTableInclude = Buff.getOptionalCppXMsgTableInclude();
			String CppXMsgTableFormatters = Buff.getOptionalCppXMsgTableFormatters();
			String CppXMsgRqstTableInclude = Buff.getOptionalCppXMsgRqstTableInclude();
			String CppXMsgRspnTableInclude = Buff.getOptionalCppXMsgRspnTableInclude();
			String CppXMsgClientTableInclude = Buff.getOptionalCppXMsgClientTableInclude();
			String CppXMsgRqstTableBody = Buff.getOptionalCppXMsgRqstTableBody();
			String CppXMsgRspnTableBody = Buff.getOptionalCppXMsgRspnTableBody();
			String CppXMsgClientTableBody = Buff.getOptionalCppXMsgClientTableBody();
			String HppObjMembers = Buff.getOptionalHppObjMembers();
			String HppObjInterface = Buff.getOptionalHppObjInterface();
			String HppObjInclude = Buff.getOptionalHppObjInclude();
			String HppObjImplementation = Buff.getOptionalHppObjImplementation();
			String HppEditObjMembers = Buff.getOptionalHppEditObjMembers();
			String HppEditObjInterface = Buff.getOptionalHppEditObjInterface();
			String HppEditObjInclude = Buff.getOptionalHppEditObjInclude();
			String HppEditObjImplementation = Buff.getOptionalHppEditObjImplementation();
			String HppTableInclude = Buff.getOptionalHppTableInclude();
			String HppTableMembers = Buff.getOptionalHppTableMembers();
			String HppTableInterface = Buff.getOptionalHppTableInterface();
			String HppTableImplementation = Buff.getOptionalHppTableImplementation();
			String HppTableObjInclude = Buff.getOptionalHppTableObjInclude();
			String HppTableObjMembers = Buff.getOptionalHppTableObjMembers();
			String HppTableObjInterface = Buff.getOptionalHppTableObjInterface();
			String HppTableObjImplementation = Buff.getOptionalHppTableObjImplementation();
			String HppDb2LUWTableInclude = Buff.getOptionalHppDb2LUWTableInclude();
			String HppDb2LUWTableMembers = Buff.getOptionalHppDb2LUWTableMembers();
			String HppDb2LUWTableImplementation = Buff.getOptionalHppDb2LUWTableImplementation();
			String HppMSSqlTableInclude = Buff.getOptionalHppMSSqlTableInclude();
			String HppMSSqlTableMembers = Buff.getOptionalHppMSSqlTableMembers();
			String HppMSSqlTableImplementation = Buff.getOptionalHppMSSqlTableImplementation();
			String HppMySqlTableInclude = Buff.getOptionalHppMySqlTableInclude();
			String HppMySqlTableMembers = Buff.getOptionalHppMySqlTableMembers();
			String HppMySqlTableImplementation = Buff.getOptionalHppMySqlTableImplementation();
			String HppOracleTableInclude = Buff.getOptionalHppOracleTableInclude();
			String HppOracleTableMembers = Buff.getOptionalHppOracleTableMembers();
			String HppOracleTableImplementation = Buff.getOptionalHppOracleTableImplementation();
			String HppPgSqlTableInclude = Buff.getOptionalHppPgSqlTableInclude();
			String HppPgSqlTableMembers = Buff.getOptionalHppPgSqlTableMembers();
			String HppPgSqlTableImplementation = Buff.getOptionalHppPgSqlTableImplementation();
			String HppRamTableInclude = Buff.getOptionalHppRamTableInclude();
			String HppRamTableMembers = Buff.getOptionalHppRamTableMembers();
			String HppRamTableImplementation = Buff.getOptionalHppRamTableImplementation();
			String HppSaxLoaderInclude = Buff.getOptionalHppSaxLoaderInclude();
			String HppSaxLoaderStartElement = Buff.getOptionalHppSaxLoaderStartElement();
			String HppSaxLoaderEndElement = Buff.getOptionalHppSaxLoaderEndElement();
			String HppXMsgTableInclude = Buff.getOptionalHppXMsgTableInclude();
			String HppXMsgTableFormatters = Buff.getOptionalHppXMsgTableFormatters();
			String HppXMsgRqstTableInclude = Buff.getOptionalHppXMsgRqstTableInclude();
			String HppXMsgRspnTableInclude = Buff.getOptionalHppXMsgRspnTableInclude();
			String HppXMsgClientTableInclude = Buff.getOptionalHppXMsgClientTableInclude();
			String HppXMsgRqstTableBody = Buff.getOptionalHppXMsgRqstTableBody();
			String HppXMsgRspnTableBody = Buff.getOptionalHppXMsgRspnTableBody();
			String HppXMsgClientTableBody = Buff.getOptionalHppXMsgClientTableBody();
			String CsObjMembers = Buff.getOptionalCsObjMembers();
			String CsObjInterface = Buff.getOptionalCsObjInterface();
			String CsObjUsing = Buff.getOptionalCsObjUsing();
			String CsObjImplementation = Buff.getOptionalCsObjImplementation();
			String CsEditObjMembers = Buff.getOptionalCsEditObjMembers();
			String CsEditObjInterface = Buff.getOptionalCsEditObjInterface();
			String CsEditObjUsing = Buff.getOptionalCsEditObjUsing();
			String CsEditObjImplementation = Buff.getOptionalCsEditObjImplementation();
			String CsTableUsing = Buff.getOptionalCsTableUsing();
			String CsTableMembers = Buff.getOptionalCsTableMembers();
			String CsTableInterface = Buff.getOptionalCsTableInterface();
			String CsTableImplementation = Buff.getOptionalCsTableImplementation();
			String CsTableObjUsing = Buff.getOptionalCsTableObjUsing();
			String CsTableObjMembers = Buff.getOptionalCsTableObjMembers();
			String CsTableObjInterface = Buff.getOptionalCsTableObjInterface();
			String CsTableObjImplementation = Buff.getOptionalCsTableObjImplementation();
			String CsDb2LUWTableUsing = Buff.getOptionalCsDb2LUWTableUsing();
			String CsDb2LUWTableMembers = Buff.getOptionalCsDb2LUWTableMembers();
			String CsDb2LUWTableImplementation = Buff.getOptionalCsDb2LUWTableImplementation();
			String CsMSSqlTableUsing = Buff.getOptionalCsMSSqlTableUsing();
			String CsMSSqlTableMembers = Buff.getOptionalCsMSSqlTableMembers();
			String CsMSSqlTableImplementation = Buff.getOptionalCsMSSqlTableImplementation();
			String CsMySqlTableUsing = Buff.getOptionalCsMySqlTableUsing();
			String CsMySqlTableMembers = Buff.getOptionalCsMySqlTableMembers();
			String CsMySqlTableImplementation = Buff.getOptionalCsMySqlTableImplementation();
			String CsOracleTableUsing = Buff.getOptionalCsOracleTableUsing();
			String CsOracleTableMembers = Buff.getOptionalCsOracleTableMembers();
			String CsOracleTableImplementation = Buff.getOptionalCsOracleTableImplementation();
			String CsPgSqlTableUsing = Buff.getOptionalCsPgSqlTableUsing();
			String CsPgSqlTableMembers = Buff.getOptionalCsPgSqlTableMembers();
			String CsPgSqlTableImplementation = Buff.getOptionalCsPgSqlTableImplementation();
			String CsRamTableUsing = Buff.getOptionalCsRamTableUsing();
			String CsRamTableMembers = Buff.getOptionalCsRamTableMembers();
			String CsRamTableImplementation = Buff.getOptionalCsRamTableImplementation();
			String CsSaxLoaderUsing = Buff.getOptionalCsSaxLoaderUsing();
			String CsSaxLoaderStartElement = Buff.getOptionalCsSaxLoaderStartElement();
			String CsSaxLoaderEndElement = Buff.getOptionalCsSaxLoaderEndElement();
			String CsXMsgTableUsing = Buff.getOptionalCsXMsgTableUsing();
			String CsXMsgTableFormatters = Buff.getOptionalCsXMsgTableFormatters();
			String CsXMsgRqstTableUsing = Buff.getOptionalCsXMsgRqstTableUsing();
			String CsXMsgRspnTableUsing = Buff.getOptionalCsXMsgRspnTableUsing();
			String CsXMsgClientTableUsing = Buff.getOptionalCsXMsgClientTableUsing();
			String CsXMsgRqstTableBody = Buff.getOptionalCsXMsgRqstTableBody();
			String CsXMsgRspnTableBody = Buff.getOptionalCsXMsgRspnTableBody();
			String CsXMsgClientTableBody = Buff.getOptionalCsXMsgClientTableBody();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_tbldef( ?, ?, ?, ?, ?, ?, ?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"? ); end;" );
			int argIdx = 1;
			stmtUpdateByPKey.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtUpdateByPKey.setString( argIdx++, ClassCode );
			stmtUpdateByPKey.setLong( argIdx++, TenantId );
			stmtUpdateByPKey.setLong( argIdx++, Id );
			stmtUpdateByPKey.setLong( argIdx++, SchemaDefId );
			if( DefSchemaTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtUpdateByPKey.setString( argIdx++, Name );
			if( DbName != null ) {
				stmtUpdateByPKey.setString( argIdx++, DbName );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ShortName != null ) {
				stmtUpdateByPKey.setString( argIdx++, ShortName );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Label != null ) {
				stmtUpdateByPKey.setString( argIdx++, Label );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ShortDescription != null ) {
				stmtUpdateByPKey.setString( argIdx++, ShortDescription );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( Description != null ) {
				stmtUpdateByPKey.setString( argIdx++, Description );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( PageData ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( PrimaryIndexTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, PrimaryIndexTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrimaryIndexId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, PrimaryIndexId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtUpdateByPKey.setString( argIdx++, TableClassCode );
			if( LookupIndexTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, LookupIndexTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( LookupIndexId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, LookupIndexId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, AltIndexTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( AltIndexId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, AltIndexId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, QualifyingTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( QualifyingTableId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, QualifyingTableId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( IsInstantiable ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( HasHistory ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( HasAuditColumns ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( IsMutable ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( IsServerOnly ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			stmtUpdateByPKey.setShort( argIdx++, (short)LoaderBehaviour.ordinal() );
			stmtUpdateByPKey.setShort( argIdx++, (short)SecScope.ordinal() );
			if( JObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, JObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JEditObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JEditObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JEditObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, JEditObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JEditObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JEditObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JEditObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JEditObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableObjImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableObjImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JTableObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JTableObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JDb2LUWTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JDb2LUWTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JDb2LUWTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JDb2LUWTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JDb2LUWTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JDb2LUWTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMSSqlTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMSSqlTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMSSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMSSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMSSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMSSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMySqlTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMySqlTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMySqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMySqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JMySqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JMySqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JOracleTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JOracleTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JOracleTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JOracleTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JOracleTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JOracleTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JPgSqlTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JPgSqlTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JPgSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JPgSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JPgSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JPgSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JRamTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JRamTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JRamTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, JRamTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JRamTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, JRamTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JSaxLoaderImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSaxLoaderImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JSaxLoaderStartElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSaxLoaderStartElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JSaxLoaderEndElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, JSaxLoaderEndElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgTableFormatters != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgTableFormatters );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgRqstTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRqstTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgRspnTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRspnTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgClientTableImport != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgClientTableImport );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgRqstTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRqstTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgRspnTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgRspnTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( JXMsgClientTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, JXMsgClientTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppObjInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppObjInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppEditObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppEditObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppEditObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppEditObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppEditObjInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppEditObjInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppEditObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppEditObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppTableInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableObjInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppTableObjInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppTableObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppTableObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppTableObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppTableObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppDb2LUWTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppDb2LUWTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppDb2LUWTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppDb2LUWTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppDb2LUWTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppDb2LUWTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMSSqlTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppMSSqlTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMSSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppMSSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMSSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppMSSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMySqlTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppMySqlTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMySqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppMySqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppMySqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppMySqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppOracleTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppOracleTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppOracleTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppOracleTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppOracleTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppOracleTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppPgSqlTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppPgSqlTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppPgSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppPgSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppPgSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppPgSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppRamTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppRamTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppRamTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppRamTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppRamTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppRamTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppSaxLoaderInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppSaxLoaderInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppSaxLoaderStartElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppSaxLoaderStartElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppSaxLoaderEndElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppSaxLoaderEndElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppXMsgTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgTableFormatters != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppXMsgTableFormatters );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgRqstTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppXMsgRqstTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgRspnTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppXMsgRspnTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgClientTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppXMsgClientTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgRqstTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppXMsgRqstTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgRspnTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppXMsgRspnTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CppXMsgClientTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, CppXMsgClientTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppObjInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppObjInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppEditObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppEditObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppEditObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppEditObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppEditObjInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppEditObjInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppEditObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppEditObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppTableInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableObjInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppTableObjInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppTableObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppTableObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppTableObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppTableObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppDb2LUWTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppDb2LUWTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppDb2LUWTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppDb2LUWTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppDb2LUWTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppDb2LUWTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMSSqlTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppMSSqlTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMSSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppMSSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMSSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppMSSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMySqlTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppMySqlTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMySqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppMySqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppMySqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppMySqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppOracleTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppOracleTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppOracleTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppOracleTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppOracleTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppOracleTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppPgSqlTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppPgSqlTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppPgSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppPgSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppPgSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppPgSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppRamTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppRamTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppRamTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppRamTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppRamTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppRamTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppSaxLoaderInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppSaxLoaderInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppSaxLoaderStartElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppSaxLoaderStartElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppSaxLoaderEndElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppSaxLoaderEndElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppXMsgTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgTableFormatters != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppXMsgTableFormatters );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgRqstTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppXMsgRqstTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgRspnTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppXMsgRspnTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgClientTableInclude != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppXMsgClientTableInclude );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgRqstTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppXMsgRqstTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgRspnTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppXMsgRspnTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( HppXMsgClientTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, HppXMsgClientTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsObjUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsObjUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsEditObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsEditObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsEditObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsEditObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsEditObjUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsEditObjUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsEditObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsEditObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsTableInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableObjUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsTableObjUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableObjMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsTableObjMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableObjInterface != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsTableObjInterface );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsTableObjImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsTableObjImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsDb2LUWTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsDb2LUWTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsDb2LUWTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsDb2LUWTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsDb2LUWTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsDb2LUWTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMSSqlTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsMSSqlTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMSSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsMSSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMSSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsMSSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMySqlTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsMySqlTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMySqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsMySqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsMySqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsMySqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsOracleTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsOracleTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsOracleTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsOracleTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsOracleTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsOracleTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsPgSqlTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsPgSqlTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsPgSqlTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsPgSqlTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsPgSqlTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsPgSqlTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsRamTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsRamTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsRamTableMembers != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsRamTableMembers );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsRamTableImplementation != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsRamTableImplementation );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsSaxLoaderUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsSaxLoaderUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsSaxLoaderStartElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsSaxLoaderStartElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsSaxLoaderEndElement != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsSaxLoaderEndElement );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsXMsgTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgTableFormatters != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsXMsgTableFormatters );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgRqstTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsXMsgRqstTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgRspnTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsXMsgRspnTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgClientTableUsing != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsXMsgClientTableUsing );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgRqstTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsXMsgRqstTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgRspnTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsXMsgRspnTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			if( CsXMsgClientTableBody != null ) {
				stmtUpdateByPKey.setString( argIdx++, CsXMsgClientTableBody );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.CLOB );
			}
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			resultSet = (ResultSet)stmtUpdateByPKey.getObject( 1 );
			if( resultSet != null ) {
				try {
					if( resultSet.next() ) {
						CFBamTableBuff updatedBuff = unpackTableResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw new CFLibRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
				Buff.setRequiredSchemaDefId( updatedBuff.getRequiredSchemaDefId() );
				Buff.setOptionalDefSchemaTenantId( updatedBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( updatedBuff.getOptionalDefSchemaId() );
				Buff.setRequiredName( updatedBuff.getRequiredName() );
				Buff.setOptionalDbName( updatedBuff.getOptionalDbName() );
				Buff.setOptionalShortName( updatedBuff.getOptionalShortName() );
				Buff.setOptionalLabel( updatedBuff.getOptionalLabel() );
				Buff.setOptionalShortDescription( updatedBuff.getOptionalShortDescription() );
				Buff.setOptionalDescription( updatedBuff.getOptionalDescription() );
				Buff.setRequiredPageData( updatedBuff.getRequiredPageData() );
				Buff.setOptionalPrimaryIndexTenantId( updatedBuff.getOptionalPrimaryIndexTenantId() );
				Buff.setOptionalPrimaryIndexId( updatedBuff.getOptionalPrimaryIndexId() );
				Buff.setRequiredTableClassCode( updatedBuff.getRequiredTableClassCode() );
				Buff.setOptionalLookupIndexTenantId( updatedBuff.getOptionalLookupIndexTenantId() );
				Buff.setOptionalLookupIndexId( updatedBuff.getOptionalLookupIndexId() );
				Buff.setOptionalAltIndexTenantId( updatedBuff.getOptionalAltIndexTenantId() );
				Buff.setOptionalAltIndexId( updatedBuff.getOptionalAltIndexId() );
				Buff.setOptionalQualifyingTenantId( updatedBuff.getOptionalQualifyingTenantId() );
				Buff.setOptionalQualifyingTableId( updatedBuff.getOptionalQualifyingTableId() );
				Buff.setRequiredIsInstantiable( updatedBuff.getRequiredIsInstantiable() );
				Buff.setRequiredHasHistory( updatedBuff.getRequiredHasHistory() );
				Buff.setRequiredHasAuditColumns( updatedBuff.getRequiredHasAuditColumns() );
				Buff.setRequiredIsMutable( updatedBuff.getRequiredIsMutable() );
				Buff.setRequiredIsServerOnly( updatedBuff.getRequiredIsServerOnly() );
				Buff.setRequiredLoaderBehaviour( updatedBuff.getRequiredLoaderBehaviour() );
				Buff.setRequiredSecScope( updatedBuff.getRequiredSecScope() );
				Buff.setOptionalJObjMembers( updatedBuff.getOptionalJObjMembers() );
				Buff.setOptionalJObjInterface( updatedBuff.getOptionalJObjInterface() );
				Buff.setOptionalJObjImport( updatedBuff.getOptionalJObjImport() );
				Buff.setOptionalJObjImplementation( updatedBuff.getOptionalJObjImplementation() );
				Buff.setOptionalJEditObjMembers( updatedBuff.getOptionalJEditObjMembers() );
				Buff.setOptionalJEditObjInterface( updatedBuff.getOptionalJEditObjInterface() );
				Buff.setOptionalJEditObjImport( updatedBuff.getOptionalJEditObjImport() );
				Buff.setOptionalJEditObjImplementation( updatedBuff.getOptionalJEditObjImplementation() );
				Buff.setOptionalJTableImport( updatedBuff.getOptionalJTableImport() );
				Buff.setOptionalJTableMembers( updatedBuff.getOptionalJTableMembers() );
				Buff.setOptionalJTableInterface( updatedBuff.getOptionalJTableInterface() );
				Buff.setOptionalJTableImplementation( updatedBuff.getOptionalJTableImplementation() );
				Buff.setOptionalJTableObjImport( updatedBuff.getOptionalJTableObjImport() );
				Buff.setOptionalJTableObjMembers( updatedBuff.getOptionalJTableObjMembers() );
				Buff.setOptionalJTableObjInterface( updatedBuff.getOptionalJTableObjInterface() );
				Buff.setOptionalJTableObjImplementation( updatedBuff.getOptionalJTableObjImplementation() );
				Buff.setOptionalJDb2LUWTableImport( updatedBuff.getOptionalJDb2LUWTableImport() );
				Buff.setOptionalJDb2LUWTableMembers( updatedBuff.getOptionalJDb2LUWTableMembers() );
				Buff.setOptionalJDb2LUWTableImplementation( updatedBuff.getOptionalJDb2LUWTableImplementation() );
				Buff.setOptionalJMSSqlTableImport( updatedBuff.getOptionalJMSSqlTableImport() );
				Buff.setOptionalJMSSqlTableMembers( updatedBuff.getOptionalJMSSqlTableMembers() );
				Buff.setOptionalJMSSqlTableImplementation( updatedBuff.getOptionalJMSSqlTableImplementation() );
				Buff.setOptionalJMySqlTableImport( updatedBuff.getOptionalJMySqlTableImport() );
				Buff.setOptionalJMySqlTableMembers( updatedBuff.getOptionalJMySqlTableMembers() );
				Buff.setOptionalJMySqlTableImplementation( updatedBuff.getOptionalJMySqlTableImplementation() );
				Buff.setOptionalJOracleTableImport( updatedBuff.getOptionalJOracleTableImport() );
				Buff.setOptionalJOracleTableMembers( updatedBuff.getOptionalJOracleTableMembers() );
				Buff.setOptionalJOracleTableImplementation( updatedBuff.getOptionalJOracleTableImplementation() );
				Buff.setOptionalJPgSqlTableImport( updatedBuff.getOptionalJPgSqlTableImport() );
				Buff.setOptionalJPgSqlTableMembers( updatedBuff.getOptionalJPgSqlTableMembers() );
				Buff.setOptionalJPgSqlTableImplementation( updatedBuff.getOptionalJPgSqlTableImplementation() );
				Buff.setOptionalJRamTableImport( updatedBuff.getOptionalJRamTableImport() );
				Buff.setOptionalJRamTableMembers( updatedBuff.getOptionalJRamTableMembers() );
				Buff.setOptionalJRamTableImplementation( updatedBuff.getOptionalJRamTableImplementation() );
				Buff.setOptionalJSaxLoaderImport( updatedBuff.getOptionalJSaxLoaderImport() );
				Buff.setOptionalJSaxLoaderStartElement( updatedBuff.getOptionalJSaxLoaderStartElement() );
				Buff.setOptionalJSaxLoaderEndElement( updatedBuff.getOptionalJSaxLoaderEndElement() );
				Buff.setOptionalJXMsgTableImport( updatedBuff.getOptionalJXMsgTableImport() );
				Buff.setOptionalJXMsgTableFormatters( updatedBuff.getOptionalJXMsgTableFormatters() );
				Buff.setOptionalJXMsgRqstTableImport( updatedBuff.getOptionalJXMsgRqstTableImport() );
				Buff.setOptionalJXMsgRspnTableImport( updatedBuff.getOptionalJXMsgRspnTableImport() );
				Buff.setOptionalJXMsgClientTableImport( updatedBuff.getOptionalJXMsgClientTableImport() );
				Buff.setOptionalJXMsgRqstTableBody( updatedBuff.getOptionalJXMsgRqstTableBody() );
				Buff.setOptionalJXMsgRspnTableBody( updatedBuff.getOptionalJXMsgRspnTableBody() );
				Buff.setOptionalJXMsgClientTableBody( updatedBuff.getOptionalJXMsgClientTableBody() );
				Buff.setOptionalCppObjMembers( updatedBuff.getOptionalCppObjMembers() );
				Buff.setOptionalCppObjInterface( updatedBuff.getOptionalCppObjInterface() );
				Buff.setOptionalCppObjInclude( updatedBuff.getOptionalCppObjInclude() );
				Buff.setOptionalCppObjImplementation( updatedBuff.getOptionalCppObjImplementation() );
				Buff.setOptionalCppEditObjMembers( updatedBuff.getOptionalCppEditObjMembers() );
				Buff.setOptionalCppEditObjInterface( updatedBuff.getOptionalCppEditObjInterface() );
				Buff.setOptionalCppEditObjInclude( updatedBuff.getOptionalCppEditObjInclude() );
				Buff.setOptionalCppEditObjImplementation( updatedBuff.getOptionalCppEditObjImplementation() );
				Buff.setOptionalCppTableInclude( updatedBuff.getOptionalCppTableInclude() );
				Buff.setOptionalCppTableMembers( updatedBuff.getOptionalCppTableMembers() );
				Buff.setOptionalCppTableInterface( updatedBuff.getOptionalCppTableInterface() );
				Buff.setOptionalCppTableImplementation( updatedBuff.getOptionalCppTableImplementation() );
				Buff.setOptionalCppTableObjInclude( updatedBuff.getOptionalCppTableObjInclude() );
				Buff.setOptionalCppTableObjMembers( updatedBuff.getOptionalCppTableObjMembers() );
				Buff.setOptionalCppTableObjInterface( updatedBuff.getOptionalCppTableObjInterface() );
				Buff.setOptionalCppTableObjImplementation( updatedBuff.getOptionalCppTableObjImplementation() );
				Buff.setOptionalCppDb2LUWTableInclude( updatedBuff.getOptionalCppDb2LUWTableInclude() );
				Buff.setOptionalCppDb2LUWTableMembers( updatedBuff.getOptionalCppDb2LUWTableMembers() );
				Buff.setOptionalCppDb2LUWTableImplementation( updatedBuff.getOptionalCppDb2LUWTableImplementation() );
				Buff.setOptionalCppMSSqlTableInclude( updatedBuff.getOptionalCppMSSqlTableInclude() );
				Buff.setOptionalCppMSSqlTableMembers( updatedBuff.getOptionalCppMSSqlTableMembers() );
				Buff.setOptionalCppMSSqlTableImplementation( updatedBuff.getOptionalCppMSSqlTableImplementation() );
				Buff.setOptionalCppMySqlTableInclude( updatedBuff.getOptionalCppMySqlTableInclude() );
				Buff.setOptionalCppMySqlTableMembers( updatedBuff.getOptionalCppMySqlTableMembers() );
				Buff.setOptionalCppMySqlTableImplementation( updatedBuff.getOptionalCppMySqlTableImplementation() );
				Buff.setOptionalCppOracleTableInclude( updatedBuff.getOptionalCppOracleTableInclude() );
				Buff.setOptionalCppOracleTableMembers( updatedBuff.getOptionalCppOracleTableMembers() );
				Buff.setOptionalCppOracleTableImplementation( updatedBuff.getOptionalCppOracleTableImplementation() );
				Buff.setOptionalCppPgSqlTableInclude( updatedBuff.getOptionalCppPgSqlTableInclude() );
				Buff.setOptionalCppPgSqlTableMembers( updatedBuff.getOptionalCppPgSqlTableMembers() );
				Buff.setOptionalCppPgSqlTableImplementation( updatedBuff.getOptionalCppPgSqlTableImplementation() );
				Buff.setOptionalCppRamTableInclude( updatedBuff.getOptionalCppRamTableInclude() );
				Buff.setOptionalCppRamTableMembers( updatedBuff.getOptionalCppRamTableMembers() );
				Buff.setOptionalCppRamTableImplementation( updatedBuff.getOptionalCppRamTableImplementation() );
				Buff.setOptionalCppSaxLoaderInclude( updatedBuff.getOptionalCppSaxLoaderInclude() );
				Buff.setOptionalCppSaxLoaderStartElement( updatedBuff.getOptionalCppSaxLoaderStartElement() );
				Buff.setOptionalCppSaxLoaderEndElement( updatedBuff.getOptionalCppSaxLoaderEndElement() );
				Buff.setOptionalCppXMsgTableInclude( updatedBuff.getOptionalCppXMsgTableInclude() );
				Buff.setOptionalCppXMsgTableFormatters( updatedBuff.getOptionalCppXMsgTableFormatters() );
				Buff.setOptionalCppXMsgRqstTableInclude( updatedBuff.getOptionalCppXMsgRqstTableInclude() );
				Buff.setOptionalCppXMsgRspnTableInclude( updatedBuff.getOptionalCppXMsgRspnTableInclude() );
				Buff.setOptionalCppXMsgClientTableInclude( updatedBuff.getOptionalCppXMsgClientTableInclude() );
				Buff.setOptionalCppXMsgRqstTableBody( updatedBuff.getOptionalCppXMsgRqstTableBody() );
				Buff.setOptionalCppXMsgRspnTableBody( updatedBuff.getOptionalCppXMsgRspnTableBody() );
				Buff.setOptionalCppXMsgClientTableBody( updatedBuff.getOptionalCppXMsgClientTableBody() );
				Buff.setOptionalHppObjMembers( updatedBuff.getOptionalHppObjMembers() );
				Buff.setOptionalHppObjInterface( updatedBuff.getOptionalHppObjInterface() );
				Buff.setOptionalHppObjInclude( updatedBuff.getOptionalHppObjInclude() );
				Buff.setOptionalHppObjImplementation( updatedBuff.getOptionalHppObjImplementation() );
				Buff.setOptionalHppEditObjMembers( updatedBuff.getOptionalHppEditObjMembers() );
				Buff.setOptionalHppEditObjInterface( updatedBuff.getOptionalHppEditObjInterface() );
				Buff.setOptionalHppEditObjInclude( updatedBuff.getOptionalHppEditObjInclude() );
				Buff.setOptionalHppEditObjImplementation( updatedBuff.getOptionalHppEditObjImplementation() );
				Buff.setOptionalHppTableInclude( updatedBuff.getOptionalHppTableInclude() );
				Buff.setOptionalHppTableMembers( updatedBuff.getOptionalHppTableMembers() );
				Buff.setOptionalHppTableInterface( updatedBuff.getOptionalHppTableInterface() );
				Buff.setOptionalHppTableImplementation( updatedBuff.getOptionalHppTableImplementation() );
				Buff.setOptionalHppTableObjInclude( updatedBuff.getOptionalHppTableObjInclude() );
				Buff.setOptionalHppTableObjMembers( updatedBuff.getOptionalHppTableObjMembers() );
				Buff.setOptionalHppTableObjInterface( updatedBuff.getOptionalHppTableObjInterface() );
				Buff.setOptionalHppTableObjImplementation( updatedBuff.getOptionalHppTableObjImplementation() );
				Buff.setOptionalHppDb2LUWTableInclude( updatedBuff.getOptionalHppDb2LUWTableInclude() );
				Buff.setOptionalHppDb2LUWTableMembers( updatedBuff.getOptionalHppDb2LUWTableMembers() );
				Buff.setOptionalHppDb2LUWTableImplementation( updatedBuff.getOptionalHppDb2LUWTableImplementation() );
				Buff.setOptionalHppMSSqlTableInclude( updatedBuff.getOptionalHppMSSqlTableInclude() );
				Buff.setOptionalHppMSSqlTableMembers( updatedBuff.getOptionalHppMSSqlTableMembers() );
				Buff.setOptionalHppMSSqlTableImplementation( updatedBuff.getOptionalHppMSSqlTableImplementation() );
				Buff.setOptionalHppMySqlTableInclude( updatedBuff.getOptionalHppMySqlTableInclude() );
				Buff.setOptionalHppMySqlTableMembers( updatedBuff.getOptionalHppMySqlTableMembers() );
				Buff.setOptionalHppMySqlTableImplementation( updatedBuff.getOptionalHppMySqlTableImplementation() );
				Buff.setOptionalHppOracleTableInclude( updatedBuff.getOptionalHppOracleTableInclude() );
				Buff.setOptionalHppOracleTableMembers( updatedBuff.getOptionalHppOracleTableMembers() );
				Buff.setOptionalHppOracleTableImplementation( updatedBuff.getOptionalHppOracleTableImplementation() );
				Buff.setOptionalHppPgSqlTableInclude( updatedBuff.getOptionalHppPgSqlTableInclude() );
				Buff.setOptionalHppPgSqlTableMembers( updatedBuff.getOptionalHppPgSqlTableMembers() );
				Buff.setOptionalHppPgSqlTableImplementation( updatedBuff.getOptionalHppPgSqlTableImplementation() );
				Buff.setOptionalHppRamTableInclude( updatedBuff.getOptionalHppRamTableInclude() );
				Buff.setOptionalHppRamTableMembers( updatedBuff.getOptionalHppRamTableMembers() );
				Buff.setOptionalHppRamTableImplementation( updatedBuff.getOptionalHppRamTableImplementation() );
				Buff.setOptionalHppSaxLoaderInclude( updatedBuff.getOptionalHppSaxLoaderInclude() );
				Buff.setOptionalHppSaxLoaderStartElement( updatedBuff.getOptionalHppSaxLoaderStartElement() );
				Buff.setOptionalHppSaxLoaderEndElement( updatedBuff.getOptionalHppSaxLoaderEndElement() );
				Buff.setOptionalHppXMsgTableInclude( updatedBuff.getOptionalHppXMsgTableInclude() );
				Buff.setOptionalHppXMsgTableFormatters( updatedBuff.getOptionalHppXMsgTableFormatters() );
				Buff.setOptionalHppXMsgRqstTableInclude( updatedBuff.getOptionalHppXMsgRqstTableInclude() );
				Buff.setOptionalHppXMsgRspnTableInclude( updatedBuff.getOptionalHppXMsgRspnTableInclude() );
				Buff.setOptionalHppXMsgClientTableInclude( updatedBuff.getOptionalHppXMsgClientTableInclude() );
				Buff.setOptionalHppXMsgRqstTableBody( updatedBuff.getOptionalHppXMsgRqstTableBody() );
				Buff.setOptionalHppXMsgRspnTableBody( updatedBuff.getOptionalHppXMsgRspnTableBody() );
				Buff.setOptionalHppXMsgClientTableBody( updatedBuff.getOptionalHppXMsgClientTableBody() );
				Buff.setOptionalCsObjMembers( updatedBuff.getOptionalCsObjMembers() );
				Buff.setOptionalCsObjInterface( updatedBuff.getOptionalCsObjInterface() );
				Buff.setOptionalCsObjUsing( updatedBuff.getOptionalCsObjUsing() );
				Buff.setOptionalCsObjImplementation( updatedBuff.getOptionalCsObjImplementation() );
				Buff.setOptionalCsEditObjMembers( updatedBuff.getOptionalCsEditObjMembers() );
				Buff.setOptionalCsEditObjInterface( updatedBuff.getOptionalCsEditObjInterface() );
				Buff.setOptionalCsEditObjUsing( updatedBuff.getOptionalCsEditObjUsing() );
				Buff.setOptionalCsEditObjImplementation( updatedBuff.getOptionalCsEditObjImplementation() );
				Buff.setOptionalCsTableUsing( updatedBuff.getOptionalCsTableUsing() );
				Buff.setOptionalCsTableMembers( updatedBuff.getOptionalCsTableMembers() );
				Buff.setOptionalCsTableInterface( updatedBuff.getOptionalCsTableInterface() );
				Buff.setOptionalCsTableImplementation( updatedBuff.getOptionalCsTableImplementation() );
				Buff.setOptionalCsTableObjUsing( updatedBuff.getOptionalCsTableObjUsing() );
				Buff.setOptionalCsTableObjMembers( updatedBuff.getOptionalCsTableObjMembers() );
				Buff.setOptionalCsTableObjInterface( updatedBuff.getOptionalCsTableObjInterface() );
				Buff.setOptionalCsTableObjImplementation( updatedBuff.getOptionalCsTableObjImplementation() );
				Buff.setOptionalCsDb2LUWTableUsing( updatedBuff.getOptionalCsDb2LUWTableUsing() );
				Buff.setOptionalCsDb2LUWTableMembers( updatedBuff.getOptionalCsDb2LUWTableMembers() );
				Buff.setOptionalCsDb2LUWTableImplementation( updatedBuff.getOptionalCsDb2LUWTableImplementation() );
				Buff.setOptionalCsMSSqlTableUsing( updatedBuff.getOptionalCsMSSqlTableUsing() );
				Buff.setOptionalCsMSSqlTableMembers( updatedBuff.getOptionalCsMSSqlTableMembers() );
				Buff.setOptionalCsMSSqlTableImplementation( updatedBuff.getOptionalCsMSSqlTableImplementation() );
				Buff.setOptionalCsMySqlTableUsing( updatedBuff.getOptionalCsMySqlTableUsing() );
				Buff.setOptionalCsMySqlTableMembers( updatedBuff.getOptionalCsMySqlTableMembers() );
				Buff.setOptionalCsMySqlTableImplementation( updatedBuff.getOptionalCsMySqlTableImplementation() );
				Buff.setOptionalCsOracleTableUsing( updatedBuff.getOptionalCsOracleTableUsing() );
				Buff.setOptionalCsOracleTableMembers( updatedBuff.getOptionalCsOracleTableMembers() );
				Buff.setOptionalCsOracleTableImplementation( updatedBuff.getOptionalCsOracleTableImplementation() );
				Buff.setOptionalCsPgSqlTableUsing( updatedBuff.getOptionalCsPgSqlTableUsing() );
				Buff.setOptionalCsPgSqlTableMembers( updatedBuff.getOptionalCsPgSqlTableMembers() );
				Buff.setOptionalCsPgSqlTableImplementation( updatedBuff.getOptionalCsPgSqlTableImplementation() );
				Buff.setOptionalCsRamTableUsing( updatedBuff.getOptionalCsRamTableUsing() );
				Buff.setOptionalCsRamTableMembers( updatedBuff.getOptionalCsRamTableMembers() );
				Buff.setOptionalCsRamTableImplementation( updatedBuff.getOptionalCsRamTableImplementation() );
				Buff.setOptionalCsSaxLoaderUsing( updatedBuff.getOptionalCsSaxLoaderUsing() );
				Buff.setOptionalCsSaxLoaderStartElement( updatedBuff.getOptionalCsSaxLoaderStartElement() );
				Buff.setOptionalCsSaxLoaderEndElement( updatedBuff.getOptionalCsSaxLoaderEndElement() );
				Buff.setOptionalCsXMsgTableUsing( updatedBuff.getOptionalCsXMsgTableUsing() );
				Buff.setOptionalCsXMsgTableFormatters( updatedBuff.getOptionalCsXMsgTableFormatters() );
				Buff.setOptionalCsXMsgRqstTableUsing( updatedBuff.getOptionalCsXMsgRqstTableUsing() );
				Buff.setOptionalCsXMsgRspnTableUsing( updatedBuff.getOptionalCsXMsgRspnTableUsing() );
				Buff.setOptionalCsXMsgClientTableUsing( updatedBuff.getOptionalCsXMsgClientTableUsing() );
				Buff.setOptionalCsXMsgRqstTableBody( updatedBuff.getOptionalCsXMsgRqstTableBody() );
				Buff.setOptionalCsXMsgRspnTableBody( updatedBuff.getOptionalCsXMsgRspnTableBody() );
				Buff.setOptionalCsXMsgClientTableBody( updatedBuff.getOptionalCsXMsgClientTableBody() );
				Buff.setRequiredRevision( updatedBuff.getRequiredRevision() );
					}
					else {
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Expected a single-record response, " + resultSet.getRow() + " rows selected" );
					}
				}
				catch( SQLException e ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"upd_tbldef() did not return a valid result cursor" );
				}
				finally {
					if( resultSet != null ) {
						try {
							resultSet.close();
						}
						catch( SQLException e ) {
						}
						resultSet = null;
					}
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"upd_tbldef() did not return a result cursor" );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
			if( stmtUpdateByPKey != null ) {
				try {
					stmtUpdateByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtUpdateByPKey = null;
			}
		}
	}

	public void deleteTable( CFSecAuthorization Authorization,
		CFBamTableBuff Buff )
	{
		final String S_ProcName = "deleteTable";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_tbldef( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPKey.setLong( argIdx++, TenantId );
			stmtDeleteByPKey.setLong( argIdx++, Id );
			stmtDeleteByPKey.setInt( argIdx++, Buff.getRequiredRevision() );;
			stmtDeleteByPKey.execute();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( stmtDeleteByPKey != null ) {
				try {
					stmtDeleteByPKey.close();
				}
				catch( SQLException e ) {
				}
				stmtDeleteByPKey = null;
			}
		}
	}

	public void deleteTableBySchemaDefIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId )
	{
		final String S_ProcName = "deleteTableBySchemaDefIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbyschemadefidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteBySchemaDefIdx == null ) {
					stmtDeleteBySchemaDefIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySchemaDefIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteBySchemaDefIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySchemaDefIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteBySchemaDefIdx.setLong( argIdx++, argTenantId );
				stmtDeleteBySchemaDefIdx.setLong( argIdx++, argSchemaDefId );
				int rowsUpdated = stmtDeleteBySchemaDefIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTableBySchemaDefIdx( CFSecAuthorization Authorization,
		CFBamTableBySchemaDefIdxKey argKey )
	{
		deleteTableBySchemaDefIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredSchemaDefId() );
	}

	public void deleteTableByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		final String S_ProcName = "deleteTableByDefSchemaIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbydefschemaidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByDefSchemaIdx == null ) {
					stmtDeleteByDefSchemaIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argDefSchemaTenantId != null ) {
					stmtDeleteByDefSchemaIdx.setLong( argIdx++, argDefSchemaTenantId.longValue() );
				}
				else {
					stmtDeleteByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argDefSchemaId != null ) {
					stmtDeleteByDefSchemaIdx.setLong( argIdx++, argDefSchemaId.longValue() );
				}
				else {
					stmtDeleteByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByDefSchemaIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTableByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamTableByDefSchemaIdxKey argKey )
	{
		deleteTableByDefSchemaIdx( Authorization,
			argKey.getOptionalDefSchemaTenantId(),
			argKey.getOptionalDefSchemaId() );
	}

	public void deleteTableByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId,
		String argName )
	{
		final String S_ProcName = "deleteTableByUNameIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbyunameidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByUNameIdx == null ) {
					stmtDeleteByUNameIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByUNameIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByUNameIdx.setLong( argIdx++, argSchemaDefId );
				stmtDeleteByUNameIdx.setString( argIdx++, argName );
				int rowsUpdated = stmtDeleteByUNameIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTableByUNameIdx( CFSecAuthorization Authorization,
		CFBamTableByUNameIdxKey argKey )
	{
		deleteTableByUNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredSchemaDefId(),
			argKey.getRequiredName() );
	}

	public void deleteTableBySchemaCdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argSchemaDefId,
		String argTableClassCode )
	{
		final String S_ProcName = "deleteTableBySchemaCdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbyschemacdidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteBySchemaCdIdx == null ) {
					stmtDeleteBySchemaCdIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySchemaCdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteBySchemaCdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteBySchemaCdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteBySchemaCdIdx.setLong( argIdx++, argTenantId );
				stmtDeleteBySchemaCdIdx.setLong( argIdx++, argSchemaDefId );
				stmtDeleteBySchemaCdIdx.setString( argIdx++, argTableClassCode );
				int rowsUpdated = stmtDeleteBySchemaCdIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTableBySchemaCdIdx( CFSecAuthorization Authorization,
		CFBamTableBySchemaCdIdxKey argKey )
	{
		deleteTableBySchemaCdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredSchemaDefId(),
			argKey.getRequiredTableClassCode() );
	}

	public void deleteTableByPrimaryIndexIdx( CFSecAuthorization Authorization,
		Long argPrimaryIndexTenantId,
		Long argPrimaryIndexId )
	{
		final String S_ProcName = "deleteTableByPrimaryIndexIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbyprimaryindexidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByPrimaryIndexIdx == null ) {
					stmtDeleteByPrimaryIndexIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByPrimaryIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByPrimaryIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argPrimaryIndexTenantId != null ) {
					stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, argPrimaryIndexTenantId.longValue() );
				}
				else {
					stmtDeleteByPrimaryIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argPrimaryIndexId != null ) {
					stmtDeleteByPrimaryIndexIdx.setLong( argIdx++, argPrimaryIndexId.longValue() );
				}
				else {
					stmtDeleteByPrimaryIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByPrimaryIndexIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTableByPrimaryIndexIdx( CFSecAuthorization Authorization,
		CFBamTableByPrimaryIndexIdxKey argKey )
	{
		deleteTableByPrimaryIndexIdx( Authorization,
			argKey.getOptionalPrimaryIndexTenantId(),
			argKey.getOptionalPrimaryIndexId() );
	}

	public void deleteTableByLookupIndexIdx( CFSecAuthorization Authorization,
		Long argLookupIndexTenantId,
		Long argLookupIndexId )
	{
		final String S_ProcName = "deleteTableByLookupIndexIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbylookupindexidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByLookupIndexIdx == null ) {
					stmtDeleteByLookupIndexIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByLookupIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByLookupIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByLookupIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argLookupIndexTenantId != null ) {
					stmtDeleteByLookupIndexIdx.setLong( argIdx++, argLookupIndexTenantId.longValue() );
				}
				else {
					stmtDeleteByLookupIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argLookupIndexId != null ) {
					stmtDeleteByLookupIndexIdx.setLong( argIdx++, argLookupIndexId.longValue() );
				}
				else {
					stmtDeleteByLookupIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByLookupIndexIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTableByLookupIndexIdx( CFSecAuthorization Authorization,
		CFBamTableByLookupIndexIdxKey argKey )
	{
		deleteTableByLookupIndexIdx( Authorization,
			argKey.getOptionalLookupIndexTenantId(),
			argKey.getOptionalLookupIndexId() );
	}

	public void deleteTableByAltIndexIdx( CFSecAuthorization Authorization,
		Long argAltIndexTenantId,
		Long argAltIndexId )
	{
		final String S_ProcName = "deleteTableByAltIndexIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbyaltindexidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByAltIndexIdx == null ) {
					stmtDeleteByAltIndexIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByAltIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByAltIndexIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByAltIndexIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argAltIndexTenantId != null ) {
					stmtDeleteByAltIndexIdx.setLong( argIdx++, argAltIndexTenantId.longValue() );
				}
				else {
					stmtDeleteByAltIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argAltIndexId != null ) {
					stmtDeleteByAltIndexIdx.setLong( argIdx++, argAltIndexId.longValue() );
				}
				else {
					stmtDeleteByAltIndexIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByAltIndexIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTableByAltIndexIdx( CFSecAuthorization Authorization,
		CFBamTableByAltIndexIdxKey argKey )
	{
		deleteTableByAltIndexIdx( Authorization,
			argKey.getOptionalAltIndexTenantId(),
			argKey.getOptionalAltIndexId() );
	}

	public void deleteTableByQualTableIdx( CFSecAuthorization Authorization,
		Long argQualifyingTenantId,
		Long argQualifyingTableId )
	{
		final String S_ProcName = "deleteTableByQualTableIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbyqualtableidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByQualTableIdx == null ) {
					stmtDeleteByQualTableIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByQualTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByQualTableIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByQualTableIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argQualifyingTenantId != null ) {
					stmtDeleteByQualTableIdx.setLong( argIdx++, argQualifyingTenantId.longValue() );
				}
				else {
					stmtDeleteByQualTableIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argQualifyingTableId != null ) {
					stmtDeleteByQualTableIdx.setLong( argIdx++, argQualifyingTableId.longValue() );
				}
				else {
					stmtDeleteByQualTableIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByQualTableIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTableByQualTableIdx( CFSecAuthorization Authorization,
		CFBamTableByQualTableIdxKey argKey )
	{
		deleteTableByQualTableIdx( Authorization,
			argKey.getOptionalQualifyingTenantId(),
			argKey.getOptionalQualifyingTableId() );
	}

	public void deleteTableByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteTableByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbyididx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByIdIdx == null ) {
					stmtDeleteByIdIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByIdIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByIdIdx.setLong( argIdx++, argId );
				int rowsUpdated = stmtDeleteByIdIdx.executeUpdate();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				if( resultSet != null ) {
					try {
						resultSet.close();
					}
					catch( SQLException e ) {
					}
					resultSet = null;
				}
			}
	}

	public void deleteTableByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		deleteTableByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteTableByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteTableByTenantIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_tbldefbytenantidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByTenantIdx == null ) {
					stmtDeleteByTenantIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByTenantIdx.setLong( argIdx++, argTenantId );
				int rowsUpdated = stmtDeleteByTenantIdx.executeUpdate();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTableByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		deleteTableByTenantIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	/**
	 *	Release the prepared statements.
	 *	<p>
	 *	When the schema changes connections, the prepared statements
	 *	have to be released because they contain connection-specific
	 *	information for most databases.
	 */
	public void releasePreparedStatements() {
		final String S_ProcName = "releasePreparedStatements";
		S_sqlSelectTableBuff = null;
		S_sqlSelectTableDistinctClassCode = null;

		if( stmtReadBuffByPKey != null ) {
			try {
				stmtReadBuffByPKey.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtReadBuffByPKey = null;
			}
		}
		if( stmtLockBuffByPKey != null ) {
			try {
				stmtLockBuffByPKey.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtLockBuffByPKey = null;
			}
		}
		if( stmtCreateByPKey != null ) {
			try {
				stmtCreateByPKey.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtCreateByPKey = null;
			}
		}
		if( stmtUpdateByPKey != null ) {
			try {
				stmtUpdateByPKey.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtUpdateByPKey = null;
			}
		}
		if( stmtDeleteByPKey != null ) {
			try {
				stmtDeleteByPKey.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtDeleteByPKey = null;
			}
		}
		if( stmtDeleteByIdIdx != null ) {
			try {
				stmtDeleteByIdIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByIdIdx = null;
		}
		if( stmtDeleteByTenantIdx != null ) {
			try {
				stmtDeleteByTenantIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByTenantIdx = null;
		}
		if( stmtDeleteBySchemaDefIdx != null ) {
			try {
				stmtDeleteBySchemaDefIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteBySchemaDefIdx = null;
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByDefSchemaIdx = null;
		}
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByUNameIdx = null;
		}
		if( stmtDeleteBySchemaCdIdx != null ) {
			try {
				stmtDeleteBySchemaCdIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteBySchemaCdIdx = null;
		}
		if( stmtDeleteByPrimaryIndexIdx != null ) {
			try {
				stmtDeleteByPrimaryIndexIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByPrimaryIndexIdx = null;
		}
		if( stmtDeleteByLookupIndexIdx != null ) {
			try {
				stmtDeleteByLookupIndexIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByLookupIndexIdx = null;
		}
		if( stmtDeleteByAltIndexIdx != null ) {
			try {
				stmtDeleteByAltIndexIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByAltIndexIdx = null;
		}
		if( stmtDeleteByQualTableIdx != null ) {
			try {
				stmtDeleteByQualTableIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByQualTableIdx = null;
		}
		if( stmtReadAllBuff != null ) {
			try {
				stmtReadAllBuff.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				stmtReadAllBuff = null;
			}
		}
		if( stmtReadBuffByIdIdx != null ) {
			try {
				stmtReadBuffByIdIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByIdIdx = null;
		}
		if( stmtReadBuffByTenantIdx != null ) {
			try {
				stmtReadBuffByTenantIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByTenantIdx = null;
		}
		if( stmtDeleteByIdIdx != null ) {
			try {
				stmtDeleteByIdIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByIdIdx = null;
		}
		if( stmtDeleteByTenantIdx != null ) {
			try {
				stmtDeleteByTenantIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByTenantIdx = null;
		}
		if( stmtReadBuffBySchemaDefIdx != null ) {
			try {
				stmtReadBuffBySchemaDefIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffBySchemaDefIdx = null;
		}
		if( stmtReadBuffByDefSchemaIdx != null ) {
			try {
				stmtReadBuffByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByDefSchemaIdx = null;
		}
		if( stmtReadBuffByUNameIdx != null ) {
			try {
				stmtReadBuffByUNameIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByUNameIdx = null;
		}
		if( stmtReadBuffBySchemaCdIdx != null ) {
			try {
				stmtReadBuffBySchemaCdIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffBySchemaCdIdx = null;
		}
		if( stmtReadBuffByPrimaryIndexIdx != null ) {
			try {
				stmtReadBuffByPrimaryIndexIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByPrimaryIndexIdx = null;
		}
		if( stmtReadBuffByLookupIndexIdx != null ) {
			try {
				stmtReadBuffByLookupIndexIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByLookupIndexIdx = null;
		}
		if( stmtReadBuffByAltIndexIdx != null ) {
			try {
				stmtReadBuffByAltIndexIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByAltIndexIdx = null;
		}
		if( stmtReadBuffByQualTableIdx != null ) {
			try {
				stmtReadBuffByQualTableIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByQualTableIdx = null;
		}
		if( stmtDeleteBySchemaDefIdx != null ) {
			try {
				stmtDeleteBySchemaDefIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteBySchemaDefIdx = null;
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByDefSchemaIdx = null;
		}
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByUNameIdx = null;
		}
		if( stmtDeleteBySchemaCdIdx != null ) {
			try {
				stmtDeleteBySchemaCdIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteBySchemaCdIdx = null;
		}
		if( stmtDeleteByPrimaryIndexIdx != null ) {
			try {
				stmtDeleteByPrimaryIndexIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByPrimaryIndexIdx = null;
		}
		if( stmtDeleteByLookupIndexIdx != null ) {
			try {
				stmtDeleteByLookupIndexIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByLookupIndexIdx = null;
		}
		if( stmtDeleteByAltIndexIdx != null ) {
			try {
				stmtDeleteByAltIndexIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByAltIndexIdx = null;
		}
		if( stmtDeleteByQualTableIdx != null ) {
			try {
				stmtDeleteByQualTableIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByQualTableIdx = null;
		}
	}
}
