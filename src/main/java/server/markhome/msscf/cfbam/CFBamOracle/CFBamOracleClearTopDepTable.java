// Description: Java 11 Oracle Jdbc DbIO implementation for ClearTopDep.

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
 *	CFBamOracleClearTopDepTable Oracle Jdbc DbIO implementation
 *	for ClearTopDep.
 */
public class CFBamOracleClearTopDepTable
	implements ICFBamClearTopDepTable
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
	protected PreparedStatement stmtReadBuffByClearDepIdx = null;
	protected PreparedStatement stmtReadBuffByDefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByClearDepIdx = null;
	protected PreparedStatement stmtDeleteByDefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByClrTopDepTblIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtReadBuffByPrevIdx = null;
	protected PreparedStatement stmtReadBuffByNextIdx = null;
	protected PreparedStatement stmtDeleteByClrTopDepTblIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtDeleteByPrevIdx = null;
	protected PreparedStatement stmtDeleteByNextIdx = null;

	public CFBamOracleClearTopDepTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createClearTopDep( CFSecAuthorization Authorization,
		CFBamClearTopDepBuff Buff )
	{
		final String S_ProcName = "createClearTopDep";
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long RelationId = Buff.getRequiredRelationId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			long TableTenantId = Buff.getRequiredTableTenantId();
			long TableId = Buff.getRequiredTableId();
			String Name = Buff.getRequiredName();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_clr_topdep( ?, ?, ?, ?, ?, ?, ?" + ", "
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
			stmtCreateByPKey.setLong( argIdx++, RelationId );
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
			stmtCreateByPKey.setLong( argIdx++, TableTenantId );
			stmtCreateByPKey.setLong( argIdx++, TableId );
			stmtCreateByPKey.setString( argIdx++, Name );
			if( PrevTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, PrevTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrevId != null ) {
				stmtCreateByPKey.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextTenantId != null ) {
				stmtCreateByPKey.setLong( argIdx++, NextTenantId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextId != null ) {
				stmtCreateByPKey.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"crt_clr_topdep() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamClearTopDepBuff createdBuff = unpackClearTopDepResultSetToBuff( resultSet );
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
				Buff.setRequiredRelationId( createdBuff.getRequiredRelationId() );
				Buff.setOptionalDefSchemaTenantId( createdBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( createdBuff.getOptionalDefSchemaId() );
				Buff.setRequiredTableTenantId( createdBuff.getRequiredTableTenantId() );
				Buff.setRequiredTableId( createdBuff.getRequiredTableId() );
				Buff.setRequiredName( createdBuff.getRequiredName() );
				Buff.setOptionalPrevTenantId( createdBuff.getOptionalPrevTenantId() );
				Buff.setOptionalPrevId( createdBuff.getOptionalPrevId() );
				Buff.setOptionalNextTenantId( createdBuff.getOptionalNextTenantId() );
				Buff.setOptionalNextId( createdBuff.getOptionalNextId() );
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
					"crt_clr_topdep() did not return a valid result set" );
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

	protected static String S_sqlSelectClearTopDepDistinctClassCode = null;

	public String getSqlSelectClearTopDepDistinctClassCode() {
		if( S_sqlSelectClearTopDepDistinctClassCode == null ) {
			S_sqlSelectClearTopDepDistinctClassCode =
					"SELECT "
				+		"DISTINCT a801.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".scopedef a801 "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".clr_dep a810 ON "
				+		"a810.TenantId = a801.TenantId "
				+		"AND a810.Id = a801.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".clr_topdep a814 ON "
				+		"a814.TenantId = a801.TenantId "
				+		"AND a814.Id = a801.Id ";
		}
		return( S_sqlSelectClearTopDepDistinctClassCode );
	}

	protected static String S_sqlSelectClearTopDepBuff = null;

	public String getSqlSelectClearTopDepBuff() {
		if( S_sqlSelectClearTopDepBuff == null ) {
			S_sqlSelectClearTopDepBuff =
					"SELECT "
				+		"a801.ClassCode, "
				+		"a801.TenantId, "
				+		"a801.Id, "
				+		"a810.RelationId, "
				+		"a810.defschtentid, "
				+		"a810.defschid, "
				+		"a814.TableTenantId, "
				+		"a814.TableId, "
				+		"a814.safe_name, "
				+		"a814.PrevTenantId, "
				+		"a814.PrevId, "
				+		"a814.NextTenantId, "
				+		"a814.NextId, "
				+		"a801.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".scopedef a801 "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".clr_dep a810 ON "
				+		"a810.TenantId = a801.TenantId "
				+		"AND a810.Id = a801.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".clr_topdep a814 ON "
				+		"a814.TenantId = a801.TenantId "
				+		"AND a814.Id = a801.Id ";
		}
		return( S_sqlSelectClearTopDepBuff );
	}

	protected CFBamClearTopDepBuff unpackClearTopDepResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackClearTopDepResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamClearTopDepBuff buff;
		if( classCode.equals( "a814" ) ) {
			buff = schema.getFactoryClearTopDep().newBuff();
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
		buff.setRequiredRelationId( resultSet.getLong( idxcol ) );
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
		buff.setRequiredTableTenantId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredTableId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredName( resultSet.getString( idxcol ) );
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalPrevTenantId( null );
			}
			else {
				buff.setOptionalPrevTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalPrevId( null );
			}
			else {
				buff.setOptionalPrevId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalNextTenantId( null );
			}
			else {
				buff.setOptionalNextTenantId( colVal );
			}
		}
		idxcol++;
		{
			long colVal = resultSet.getLong( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalNextId( null );
			}
			else {
				buff.setOptionalNextId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamClearTopDepBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClearTopDepBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamClearTopDepBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClearTopDepBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamClearTopDepBuff[] readAllDerived( CFSecAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamClearTopDepBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamClearTopDepBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamOracleClearTopDepTable.readDerivedByIdIdx() ";
		CFBamClearTopDepBuff buff;
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

	public CFBamClearTopDepBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClearTopDepBuff[] buffList = readBuffByTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamClearTopDepBuff[] readDerivedByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "readDerivedByClearDepIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClearTopDepBuff[] buffList = readBuffByClearDepIdx( Authorization,
				TenantId,
				RelationId );
		return( buffList );

	}

	public CFBamClearTopDepBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClearTopDepBuff[] buffList = readBuffByDefSchemaIdx( Authorization,
				DefSchemaTenantId,
				DefSchemaId );
		return( buffList );

	}

	public CFBamClearTopDepBuff[] readDerivedByClrTopDepTblIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId )
	{
		final String S_ProcName = "readDerivedByClrTopDepTblIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClearTopDepBuff[] buffList = readBuffByClrTopDepTblIdx( Authorization,
				TableTenantId,
				TableId );
		return( buffList );

	}

	public CFBamClearTopDepBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "CFBamOracleClearTopDepTable.readDerivedByUNameIdx() ";
		CFBamClearTopDepBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				TableTenantId,
				TableId,
				Name );
		return( buff );
	}

	public CFBamClearTopDepBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readDerivedByPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClearTopDepBuff[] buffList = readBuffByPrevIdx( Authorization,
				PrevTenantId,
				PrevId );
		return( buffList );

	}

	public CFBamClearTopDepBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readDerivedByNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamClearTopDepBuff[] buffList = readBuffByNextIdx( Authorization,
				NextTenantId,
				NextId );
		return( buffList );

	}

	public CFBamClearTopDepBuff readBuff( CFSecAuthorization Authorization,
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

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdep( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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

	public CFBamClearTopDepBuff lockBuff( CFSecAuthorization Authorization,
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

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_clr_topdep( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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

	public CFBamClearTopDepBuff[] readAllBuff( CFSecAuthorization Authorization ) {
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
			CFBamClearTopDepBuff buff = null;
			List<CFBamClearTopDepBuff> buffList = new LinkedList<CFBamClearTopDepBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdepall( ?, ?, ?, ?, ?, ? ) ); end;" );
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
						buff = unpackClearTopDepResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamClearTopDepBuff[] retBuff = new CFBamClearTopDepBuff[ buffList.size() ];
			Iterator<CFBamClearTopDepBuff> iter = buffList.iterator();
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

	public CFBamClearTopDepBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdepbyididx( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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

	public CFBamClearTopDepBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByTenantIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByTenantIdx = null;
		List<CFBamClearTopDepBuff> buffList = new LinkedList<CFBamClearTopDepBuff>();
		try {
			stmtReadBuffByTenantIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdepbytenantidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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
			CFBamClearTopDepBuff[] retBuff = new CFBamClearTopDepBuff[ buffList.size() ];
			Iterator<CFBamClearTopDepBuff> iter = buffList.iterator();
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

	public CFBamClearTopDepBuff[] readBuffByClearDepIdx( CFSecAuthorization Authorization,
		long TenantId,
		long RelationId )
	{
		final String S_ProcName = "readBuffByClearDepIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByClearDepIdx = null;
		List<CFBamClearTopDepBuff> buffList = new LinkedList<CFBamClearTopDepBuff>();
		try {
			stmtReadBuffByClearDepIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdepbycleardepidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByClearDepIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByClearDepIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClearDepIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByClearDepIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByClearDepIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClearDepIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByClearDepIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByClearDepIdx.setLong( argIdx++, RelationId );
			stmtReadBuffByClearDepIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByClearDepIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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
			CFBamClearTopDepBuff[] retBuff = new CFBamClearTopDepBuff[ buffList.size() ];
			Iterator<CFBamClearTopDepBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByClearDepIdx != null ) {
				try {
					stmtReadBuffByClearDepIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByClearDepIdx = null;
			}
		}
	}

	public CFBamClearTopDepBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readBuffByDefSchemaIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByDefSchemaIdx = null;
		List<CFBamClearTopDepBuff> buffList = new LinkedList<CFBamClearTopDepBuff>();
		try {
			stmtReadBuffByDefSchemaIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdepbydefschemaidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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
			CFBamClearTopDepBuff[] retBuff = new CFBamClearTopDepBuff[ buffList.size() ];
			Iterator<CFBamClearTopDepBuff> iter = buffList.iterator();
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

	public CFBamClearTopDepBuff[] readBuffByClrTopDepTblIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId )
	{
		final String S_ProcName = "readBuffByClrTopDepTblIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByClrTopDepTblIdx = null;
		List<CFBamClearTopDepBuff> buffList = new LinkedList<CFBamClearTopDepBuff>();
		try {
			stmtReadBuffByClrTopDepTblIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdepbyclrtopdeptblidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByClrTopDepTblIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByClrTopDepTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClrTopDepTblIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByClrTopDepTblIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByClrTopDepTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClrTopDepTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByClrTopDepTblIdx.setLong( argIdx++, TableTenantId );
			stmtReadBuffByClrTopDepTblIdx.setLong( argIdx++, TableId );
			stmtReadBuffByClrTopDepTblIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByClrTopDepTblIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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
			CFBamClearTopDepBuff[] retBuff = new CFBamClearTopDepBuff[ buffList.size() ];
			Iterator<CFBamClearTopDepBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByClrTopDepTblIdx != null ) {
				try {
					stmtReadBuffByClrTopDepTblIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByClrTopDepTblIdx = null;
			}
		}
	}

	public CFBamClearTopDepBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TableTenantId,
		long TableId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByUNameIdx = null;
		try {
			stmtReadBuffByUNameIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdepbyunameidx( ?, ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByUNameIdx.setLong( argIdx++, TableTenantId );
			stmtReadBuffByUNameIdx.setLong( argIdx++, TableId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			stmtReadBuffByUNameIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByUNameIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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

	public CFBamClearTopDepBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readBuffByPrevIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByPrevIdx = null;
		List<CFBamClearTopDepBuff> buffList = new LinkedList<CFBamClearTopDepBuff>();
		try {
			stmtReadBuffByPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdepbyprevidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByPrevIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( PrevTenantId != null ) {
				stmtReadBuffByPrevIdx.setLong( argIdx++, PrevTenantId.longValue() );
			}
			else {
				stmtReadBuffByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrevId != null ) {
				stmtReadBuffByPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtReadBuffByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByPrevIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByPrevIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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
			CFBamClearTopDepBuff[] retBuff = new CFBamClearTopDepBuff[ buffList.size() ];
			Iterator<CFBamClearTopDepBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByPrevIdx != null ) {
				try {
					stmtReadBuffByPrevIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByPrevIdx = null;
			}
		}
	}

	public CFBamClearTopDepBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readBuffByNextIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByNextIdx = null;
		List<CFBamClearTopDepBuff> buffList = new LinkedList<CFBamClearTopDepBuff>();
		try {
			stmtReadBuffByNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_clr_topdepbynextidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByNextIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( NextTenantId != null ) {
				stmtReadBuffByNextIdx.setLong( argIdx++, NextTenantId.longValue() );
			}
			else {
				stmtReadBuffByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextId != null ) {
				stmtReadBuffByNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtReadBuffByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByNextIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByNextIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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
			CFBamClearTopDepBuff[] retBuff = new CFBamClearTopDepBuff[ buffList.size() ];
			Iterator<CFBamClearTopDepBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByNextIdx != null ) {
				try {
					stmtReadBuffByNextIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByNextIdx = null;
			}
		}
	}

	public void updateClearTopDep( CFSecAuthorization Authorization,
		CFBamClearTopDepBuff Buff )
	{
		final String S_ProcName = "updateClearTopDep";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamClearTopDepBuff> buffList = new LinkedList<CFBamClearTopDepBuff>();
		try {			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			long RelationId = Buff.getRequiredRelationId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			long TableTenantId = Buff.getRequiredTableTenantId();
			long TableId = Buff.getRequiredTableId();
			String Name = Buff.getRequiredName();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_clr_topdep( ?, ?, ?, ?, ?, ?, ?" + ", "
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
			stmtUpdateByPKey.setLong( argIdx++, RelationId );
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
			stmtUpdateByPKey.setLong( argIdx++, TableTenantId );
			stmtUpdateByPKey.setLong( argIdx++, TableId );
			stmtUpdateByPKey.setString( argIdx++, Name );
			if( PrevTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, PrevTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrevId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextTenantId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, NextTenantId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextId != null ) {
				stmtUpdateByPKey.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			resultSet = (ResultSet)stmtUpdateByPKey.getObject( 1 );
			if( resultSet != null ) {
				try {
					if( resultSet.next() ) {
						CFBamClearTopDepBuff updatedBuff = unpackClearTopDepResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw new CFLibRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
				Buff.setRequiredRelationId( updatedBuff.getRequiredRelationId() );
				Buff.setOptionalDefSchemaTenantId( updatedBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( updatedBuff.getOptionalDefSchemaId() );
				Buff.setRequiredTableTenantId( updatedBuff.getRequiredTableTenantId() );
				Buff.setRequiredTableId( updatedBuff.getRequiredTableId() );
				Buff.setRequiredName( updatedBuff.getRequiredName() );
				Buff.setOptionalPrevTenantId( updatedBuff.getOptionalPrevTenantId() );
				Buff.setOptionalPrevId( updatedBuff.getOptionalPrevId() );
				Buff.setOptionalNextTenantId( updatedBuff.getOptionalNextTenantId() );
				Buff.setOptionalNextId( updatedBuff.getOptionalNextId() );
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
						"upd_clr_topdep() did not return a valid result cursor" );
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
					"upd_clr_topdep() did not return a result cursor" );
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

	public void deleteClearTopDep( CFSecAuthorization Authorization,
		CFBamClearTopDepBuff Buff )
	{
		final String S_ProcName = "deleteClearTopDep";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_clr_topdep( ?, ?, ?, ?, ?" + ", "
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

	public void deleteClearTopDepByClrTopDepTblIdx( CFSecAuthorization Authorization,
		long argTableTenantId,
		long argTableId )
	{
		final String S_ProcName = "deleteClearTopDepByClrTopDepTblIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_clr_topdepbyclrtopdeptblidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByClrTopDepTblIdx == null ) {
					stmtDeleteByClrTopDepTblIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByClrTopDepTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByClrTopDepTblIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByClrTopDepTblIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByClrTopDepTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByClrTopDepTblIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByClrTopDepTblIdx.setLong( argIdx++, argTableTenantId );
				stmtDeleteByClrTopDepTblIdx.setLong( argIdx++, argTableId );
				int rowsUpdated = stmtDeleteByClrTopDepTblIdx.executeUpdate();
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

	public void deleteClearTopDepByClrTopDepTblIdx( CFSecAuthorization Authorization,
		CFBamClearTopDepByClrTopDepTblIdxKey argKey )
	{
		deleteClearTopDepByClrTopDepTblIdx( Authorization,
			argKey.getRequiredTableTenantId(),
			argKey.getRequiredTableId() );
	}

	public void deleteClearTopDepByUNameIdx( CFSecAuthorization Authorization,
		long argTableTenantId,
		long argTableId,
		String argName )
	{
		final String S_ProcName = "deleteClearTopDepByUNameIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_clr_topdepbyunameidx( ?, ?, ?, ?, ?" + ", "
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
				stmtDeleteByUNameIdx.setLong( argIdx++, argTableTenantId );
				stmtDeleteByUNameIdx.setLong( argIdx++, argTableId );
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

	public void deleteClearTopDepByUNameIdx( CFSecAuthorization Authorization,
		CFBamClearTopDepByUNameIdxKey argKey )
	{
		deleteClearTopDepByUNameIdx( Authorization,
			argKey.getRequiredTableTenantId(),
			argKey.getRequiredTableId(),
			argKey.getRequiredName() );
	}

	public void deleteClearTopDepByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		final String S_ProcName = "deleteClearTopDepByPrevIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_clr_topdepbyprevidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByPrevIdx == null ) {
					stmtDeleteByPrevIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argPrevTenantId != null ) {
					stmtDeleteByPrevIdx.setLong( argIdx++, argPrevTenantId.longValue() );
				}
				else {
					stmtDeleteByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argPrevId != null ) {
					stmtDeleteByPrevIdx.setLong( argIdx++, argPrevId.longValue() );
				}
				else {
					stmtDeleteByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByPrevIdx.executeUpdate();
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

	public void deleteClearTopDepByPrevIdx( CFSecAuthorization Authorization,
		CFBamClearTopDepByPrevIdxKey argKey )
	{
		deleteClearTopDepByPrevIdx( Authorization,
			argKey.getOptionalPrevTenantId(),
			argKey.getOptionalPrevId() );
	}

	public void deleteClearTopDepByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		final String S_ProcName = "deleteClearTopDepByNextIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_clr_topdepbynextidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByNextIdx == null ) {
					stmtDeleteByNextIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				if( argNextTenantId != null ) {
					stmtDeleteByNextIdx.setLong( argIdx++, argNextTenantId.longValue() );
				}
				else {
					stmtDeleteByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				if( argNextId != null ) {
					stmtDeleteByNextIdx.setLong( argIdx++, argNextId.longValue() );
				}
				else {
					stmtDeleteByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByNextIdx.executeUpdate();
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

	public void deleteClearTopDepByNextIdx( CFSecAuthorization Authorization,
		CFBamClearTopDepByNextIdxKey argKey )
	{
		deleteClearTopDepByNextIdx( Authorization,
			argKey.getOptionalNextTenantId(),
			argKey.getOptionalNextId() );
	}

	public void deleteClearTopDepByClearDepIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argRelationId )
	{
		final String S_ProcName = "deleteClearTopDepByClearDepIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_clr_topdepbycleardepidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByClearDepIdx == null ) {
					stmtDeleteByClearDepIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByClearDepIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByClearDepIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByClearDepIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByClearDepIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByClearDepIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByClearDepIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByClearDepIdx.setLong( argIdx++, argRelationId );
				int rowsUpdated = stmtDeleteByClearDepIdx.executeUpdate();
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

	public void deleteClearTopDepByClearDepIdx( CFSecAuthorization Authorization,
		CFBamClearDepByClearDepIdxKey argKey )
	{
		deleteClearTopDepByClearDepIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredRelationId() );
	}

	public void deleteClearTopDepByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		final String S_ProcName = "deleteClearTopDepByDefSchemaIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_clr_topdepbydefschemaidx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteClearTopDepByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamClearDepByDefSchemaIdxKey argKey )
	{
		deleteClearTopDepByDefSchemaIdx( Authorization,
			argKey.getOptionalDefSchemaTenantId(),
			argKey.getOptionalDefSchemaId() );
	}

	public void deleteClearTopDepByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteClearTopDepByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_clr_topdepbyididx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteClearTopDepByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		deleteClearTopDepByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteClearTopDepByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteClearTopDepByTenantIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_clr_topdepbytenantidx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteClearTopDepByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		deleteClearTopDepByTenantIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamClearTopDepBuff moveBuffUp( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		final String S_ProcName = "moveBuffUp";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtMoveUp = null;
		try {
			stmtMoveUp = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".mvup_clr_topdep( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", ? ); end;" );
			int argIdx = 1;
			stmtMoveUp.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtMoveUp.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveUp.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtMoveUp.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtMoveUp.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveUp.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtMoveUp.setLong( argIdx++, TenantId );
			stmtMoveUp.setLong( argIdx++, Id );
			stmtMoveUp.setInt( argIdx++, revision );
			stmtMoveUp.execute();
			resultSet = (ResultSet)stmtMoveUp.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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
			if( stmtMoveUp != null ) {
				try {
					stmtMoveUp.close();
				}
				catch( SQLException e ) {
				}
				stmtMoveUp = null;
			}
		}
	}

	/**
	 *	Move the specified buffer down in the chain (i.e. to the next position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamClearTopDepBuff moveBuffDown( CFSecAuthorization Authorization,
		long TenantId,
		long Id,
		int revision )
	{
		final String S_ProcName = "moveBuffDown";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtMoveDown = null;
		try {
			stmtMoveDown = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".mvdn_clr_topdep( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", ? ); end;" );
			int argIdx = 1;
			stmtMoveDown.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtMoveDown.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveDown.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtMoveDown.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtMoveDown.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtMoveDown.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtMoveDown.setLong( argIdx++, TenantId );
			stmtMoveDown.setLong( argIdx++, Id );
			stmtMoveDown.setInt( argIdx++, revision );
			stmtMoveDown.execute();
			resultSet = (ResultSet)stmtMoveDown.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamClearTopDepBuff buff = unpackClearTopDepResultSetToBuff( resultSet );
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
			if( stmtMoveDown != null ) {
				try {
					stmtMoveDown.close();
				}
				catch( SQLException e ) {
				}
				stmtMoveDown = null;
			}
		}
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
		S_sqlSelectClearTopDepBuff = null;
		S_sqlSelectClearTopDepDistinctClassCode = null;

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
		if( stmtDeleteByClearDepIdx != null ) {
			try {
				stmtDeleteByClearDepIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByClearDepIdx = null;
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByDefSchemaIdx = null;
		}
		if( stmtDeleteByClrTopDepTblIdx != null ) {
			try {
				stmtDeleteByClrTopDepTblIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByClrTopDepTblIdx = null;
		}
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByUNameIdx = null;
		}
		if( stmtDeleteByPrevIdx != null ) {
			try {
				stmtDeleteByPrevIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByPrevIdx = null;
		}
		if( stmtDeleteByNextIdx != null ) {
			try {
				stmtDeleteByNextIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByNextIdx = null;
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
		if( stmtReadBuffByClearDepIdx != null ) {
			try {
				stmtReadBuffByClearDepIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByClearDepIdx = null;
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
		if( stmtDeleteByClearDepIdx != null ) {
			try {
				stmtDeleteByClearDepIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByClearDepIdx = null;
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
		if( stmtReadBuffByClrTopDepTblIdx != null ) {
			try {
				stmtReadBuffByClrTopDepTblIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByClrTopDepTblIdx = null;
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
		if( stmtReadBuffByPrevIdx != null ) {
			try {
				stmtReadBuffByPrevIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByPrevIdx = null;
		}
		if( stmtReadBuffByNextIdx != null ) {
			try {
				stmtReadBuffByNextIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByNextIdx = null;
		}
		if( stmtDeleteByClrTopDepTblIdx != null ) {
			try {
				stmtDeleteByClrTopDepTblIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByClrTopDepTblIdx = null;
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
		if( stmtDeleteByPrevIdx != null ) {
			try {
				stmtDeleteByPrevIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByPrevIdx = null;
		}
		if( stmtDeleteByNextIdx != null ) {
			try {
				stmtDeleteByNextIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByNextIdx = null;
		}
	}
}
