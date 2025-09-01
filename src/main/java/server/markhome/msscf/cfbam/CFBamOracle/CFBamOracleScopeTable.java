// Description: Java 11 Oracle Jdbc DbIO implementation for Scope.

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
 *	CFBamOracleScopeTable Oracle Jdbc DbIO implementation
 *	for Scope.
 */
public class CFBamOracleScopeTable
	implements ICFBamScopeTable
{
	private CFBamOracleSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtReadDerivedClassCode = null;
	protected PreparedStatement stmtLockDerivedClassCode = null;
	protected PreparedStatement stmtReadAllClassCode = null;
	protected PreparedStatement stmtReadClassCodeByIdIdx = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadClassCodeByTenantIdx = null;
	protected PreparedStatement stmtReadBuffByTenantIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByTenantIdx = null;

	public CFBamOracleScopeTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createScope( CFSecAuthorization Authorization,
		CFBamScopeBuff Buff )
	{
		final String S_ProcName = "createScope";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_scopedef( ?, ?, ?, ?, ?, ?, ?" + ", "
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
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"crt_scopedef() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamScopeBuff createdBuff = unpackScopeResultSetToBuff( resultSet );
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
					"crt_scopedef() did not return a valid result set" );
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

	protected static String S_sqlSelectScopeDistinctClassCode = null;

	public String getSqlSelectScopeDistinctClassCode() {
		if( S_sqlSelectScopeDistinctClassCode == null ) {
			S_sqlSelectScopeDistinctClassCode =
					"SELECT "
				+		"DISTINCT a801.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".scopedef a801 ";
		}
		return( S_sqlSelectScopeDistinctClassCode );
	}

	protected static String S_sqlSelectScopeBuff = null;

	public String getSqlSelectScopeBuff() {
		if( S_sqlSelectScopeBuff == null ) {
			S_sqlSelectScopeBuff =
					"SELECT "
				+		"a801.ClassCode, "
				+		"a801.TenantId, "
				+		"a801.Id, "
				+		"a801.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".scopedef a801 ";
		}
		return( S_sqlSelectScopeBuff );
	}

	protected CFBamScopeBuff unpackScopeResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackScopeResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamScopeBuff buff;
		if( classCode.equals( "a801" ) ) {
			buff = schema.getFactoryScope().newBuff();
		}
		else if( classCode.equals( "a802" ) ) {
			buff = schema.getFactorySchemaDef().newBuff();
		}
		else if( classCode.equals( "a804" ) ) {
			buff = schema.getFactorySchemaRef().newBuff();
		}
		else if( classCode.equals( "a805" ) ) {
			buff = schema.getFactoryServerMethod().newBuff();
		}
		else if( classCode.equals( "a806" ) ) {
			buff = schema.getFactoryServerObjFunc().newBuff();
		}
		else if( classCode.equals( "a807" ) ) {
			buff = schema.getFactoryServerProc().newBuff();
		}
		else if( classCode.equals( "a837" ) ) {
			buff = schema.getFactoryServerListFunc().newBuff();
		}
		else if( classCode.equals( "a808" ) ) {
			buff = schema.getFactoryTable().newBuff();
		}
		else if( classCode.equals( "a810" ) ) {
			buff = schema.getFactoryClearDep().newBuff();
		}
		else if( classCode.equals( "a811" ) ) {
			buff = schema.getFactoryClearSubDep1().newBuff();
		}
		else if( classCode.equals( "a812" ) ) {
			buff = schema.getFactoryClearSubDep2().newBuff();
		}
		else if( classCode.equals( "a813" ) ) {
			buff = schema.getFactoryClearSubDep3().newBuff();
		}
		else if( classCode.equals( "a814" ) ) {
			buff = schema.getFactoryClearTopDep().newBuff();
		}
		else if( classCode.equals( "a817" ) ) {
			buff = schema.getFactoryDelDep().newBuff();
		}
		else if( classCode.equals( "a818" ) ) {
			buff = schema.getFactoryDelSubDep1().newBuff();
		}
		else if( classCode.equals( "a819" ) ) {
			buff = schema.getFactoryDelSubDep2().newBuff();
		}
		else if( classCode.equals( "a81a" ) ) {
			buff = schema.getFactoryDelSubDep3().newBuff();
		}
		else if( classCode.equals( "a81b" ) ) {
			buff = schema.getFactoryDelTopDep().newBuff();
		}
		else if( classCode.equals( "a821" ) ) {
			buff = schema.getFactoryIndex().newBuff();
		}
		else if( classCode.equals( "a830" ) ) {
			buff = schema.getFactoryPopDep().newBuff();
		}
		else if( classCode.equals( "a831" ) ) {
			buff = schema.getFactoryPopSubDep1().newBuff();
		}
		else if( classCode.equals( "a832" ) ) {
			buff = schema.getFactoryPopSubDep2().newBuff();
		}
		else if( classCode.equals( "a833" ) ) {
			buff = schema.getFactoryPopSubDep3().newBuff();
		}
		else if( classCode.equals( "a834" ) ) {
			buff = schema.getFactoryPopTopDep().newBuff();
		}
		else if( classCode.equals( "a835" ) ) {
			buff = schema.getFactoryRelation().newBuff();
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
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamScopeBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamScopeBuff buff;

		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadDerivedClassCode = null;
		try {
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			Connection cnx = schema.getCnx();
			stmtReadDerivedClassCode = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_scopedefcc( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadDerivedClassCode.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadDerivedClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadDerivedClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadDerivedClassCode.setLong( argIdx++, TenantId );
			stmtReadDerivedClassCode.setLong( argIdx++, Id );
			stmtReadDerivedClassCode.execute();
			resultSet = (ResultSet)stmtReadDerivedClassCode.getObject( 1 );
			if( resultSet == null ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"rd_scopedefcc() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					classCode = resultSet.getString( 1 );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
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
			if( stmtReadDerivedClassCode != null ) {
				try {
					stmtReadDerivedClassCode.close();
				}
				catch( SQLException e ) {
				}
				stmtReadDerivedClassCode = null;
			}
		}
		if( classCode.equals( "a801" ) ) {
			buff = readBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a802" ) ) {
			buff = schema.getTableSchemaDef().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a804" ) ) {
			buff = schema.getTableSchemaRef().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a805" ) ) {
			buff = schema.getTableServerMethod().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a806" ) ) {
			buff = schema.getTableServerObjFunc().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a807" ) ) {
			buff = schema.getTableServerProc().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a837" ) ) {
			buff = schema.getTableServerListFunc().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a808" ) ) {
			buff = schema.getTableTable().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a810" ) ) {
			buff = schema.getTableClearDep().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a811" ) ) {
			buff = schema.getTableClearSubDep1().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a812" ) ) {
			buff = schema.getTableClearSubDep2().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a813" ) ) {
			buff = schema.getTableClearSubDep3().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a814" ) ) {
			buff = schema.getTableClearTopDep().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a817" ) ) {
			buff = schema.getTableDelDep().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a818" ) ) {
			buff = schema.getTableDelSubDep1().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a819" ) ) {
			buff = schema.getTableDelSubDep2().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a81a" ) ) {
			buff = schema.getTableDelSubDep3().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a81b" ) ) {
			buff = schema.getTableDelTopDep().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a821" ) ) {
			buff = schema.getTableIndex().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a830" ) ) {
			buff = schema.getTablePopDep().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a831" ) ) {
			buff = schema.getTablePopSubDep1().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a832" ) ) {
			buff = schema.getTablePopSubDep2().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a833" ) ) {
			buff = schema.getTablePopSubDep3().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a834" ) ) {
			buff = schema.getTablePopTopDep().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a835" ) ) {
			buff = schema.getTableRelation().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Did not expect ClassCode \"" + classCode + "\"" );
		}
		return( buff );
	}

	public CFBamScopeBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamScopeBuff buff;
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtLockDerivedClassCode = null;
		try {
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			Connection cnx = schema.getCnx();
			stmtLockDerivedClassCode = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_scopedefcc( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtLockDerivedClassCode.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtLockDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockDerivedClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockDerivedClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockDerivedClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockDerivedClassCode.setLong( argIdx++, TenantId );
			stmtLockDerivedClassCode.setLong( argIdx++, Id );
			stmtLockDerivedClassCode.execute();
			resultSet = (ResultSet)stmtLockDerivedClassCode.getObject( 1 );
			if( resultSet == null ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"rd_scopedefcc() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					classCode = resultSet.getString( 1 );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
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
			if( stmtLockDerivedClassCode != null ) {
				try {
					stmtLockDerivedClassCode.close();
				}
				catch( SQLException e ) {
				}
				stmtLockDerivedClassCode = null;
			}
		}
		if( classCode.equals( "a801" ) ) {
			buff = lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a802" ) ) {
			buff = schema.getTableSchemaDef().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a804" ) ) {
			buff = schema.getTableSchemaRef().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a805" ) ) {
			buff = schema.getTableServerMethod().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a806" ) ) {
			buff = schema.getTableServerObjFunc().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a807" ) ) {
			buff = schema.getTableServerProc().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a837" ) ) {
			buff = schema.getTableServerListFunc().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a808" ) ) {
			buff = schema.getTableTable().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a810" ) ) {
			buff = schema.getTableClearDep().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a811" ) ) {
			buff = schema.getTableClearSubDep1().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a812" ) ) {
			buff = schema.getTableClearSubDep2().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a813" ) ) {
			buff = schema.getTableClearSubDep3().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a814" ) ) {
			buff = schema.getTableClearTopDep().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a817" ) ) {
			buff = schema.getTableDelDep().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a818" ) ) {
			buff = schema.getTableDelSubDep1().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a819" ) ) {
			buff = schema.getTableDelSubDep2().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a81a" ) ) {
			buff = schema.getTableDelSubDep3().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a81b" ) ) {
			buff = schema.getTableDelTopDep().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a821" ) ) {
			buff = schema.getTableIndex().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a830" ) ) {
			buff = schema.getTablePopDep().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a831" ) ) {
			buff = schema.getTablePopSubDep1().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a832" ) ) {
			buff = schema.getTablePopSubDep2().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a833" ) ) {
			buff = schema.getTablePopSubDep3().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a834" ) ) {
			buff = schema.getTablePopTopDep().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a835" ) ) {
			buff = schema.getTableRelation().lockBuff( Authorization, PKey );
		}
		else {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Did not expect ClassCode \"" + classCode + "\"" );
		}
		return( buff );
	}

	public CFBamScopeBuff[] readAllDerived( CFSecAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamScopeBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		String classCode;
		ArrayList<String> classCodeList = new ArrayList<String>();
		ResultSet resultSet = null;
		CallableStatement stmtReadAllClassCode = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadAllClassCode = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_scopedefccall( ?, ?, ?, ?, ?, ? ); end;" );
			int argIdx = 1;
			stmtReadAllClassCode.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadAllClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadAllClassCode.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadAllClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllClassCode.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadAllClassCode.execute();
			resultSet = (ResultSet)stmtReadAllClassCode.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
				}
				finally {
					if( stmtReadAllClassCode != null ) {
						try {
							stmtReadAllClassCode.close();
						}
						catch( SQLException e ) {
						}
						stmtReadAllClassCode = null;
					}
				}
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
			if( stmtReadAllClassCode != null ) {
				try {
					stmtReadAllClassCode.close();
				}
				catch( SQLException e ) {
				}
				stmtReadAllClassCode = null;
			}
		}
		List<CFBamScopeBuff> resultList = new LinkedList<CFBamScopeBuff>();
		for( int classCodeIdx = 0; classCodeIdx < classCodeList.size(); classCodeIdx ++ ) {
			CFBamScopeBuff[] subList;
			classCode = classCodeList.get( classCodeIdx );
			if( classCode.equals( "a801" ) ) {
				subList = readAllBuff( Authorization );
			}
			else if( classCode.equals( "a802" ) ) {
				subList = schema.getTableSchemaDef().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a804" ) ) {
				subList = schema.getTableSchemaRef().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a805" ) ) {
				subList = schema.getTableServerMethod().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a806" ) ) {
				subList = schema.getTableServerObjFunc().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a807" ) ) {
				subList = schema.getTableServerProc().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a837" ) ) {
				subList = schema.getTableServerListFunc().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a808" ) ) {
				subList = schema.getTableTable().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a810" ) ) {
				subList = schema.getTableClearDep().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a811" ) ) {
				subList = schema.getTableClearSubDep1().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a812" ) ) {
				subList = schema.getTableClearSubDep2().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a813" ) ) {
				subList = schema.getTableClearSubDep3().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a814" ) ) {
				subList = schema.getTableClearTopDep().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a817" ) ) {
				subList = schema.getTableDelDep().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a818" ) ) {
				subList = schema.getTableDelSubDep1().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a819" ) ) {
				subList = schema.getTableDelSubDep2().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a81a" ) ) {
				subList = schema.getTableDelSubDep3().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a81b" ) ) {
				subList = schema.getTableDelTopDep().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a821" ) ) {
				subList = schema.getTableIndex().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a830" ) ) {
				subList = schema.getTablePopDep().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a831" ) ) {
				subList = schema.getTablePopSubDep1().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a832" ) ) {
				subList = schema.getTablePopSubDep2().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a833" ) ) {
				subList = schema.getTablePopSubDep3().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a834" ) ) {
				subList = schema.getTablePopTopDep().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a835" ) ) {
				subList = schema.getTableRelation().readAllBuff( Authorization );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
			for( int idxSubList = 0; idxSubList < subList.length; idxSubList ++ ) {
				resultList.add( subList[ idxSubList ] );
			}
		}
		int idx = 0;
		buffArray = new CFBamScopeBuff[ resultList.size() ];
		Iterator<CFBamScopeBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			buffArray[idx++] = iter.next();
		}
		return( buffArray );
	}

	public CFBamScopeBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamOracleScopeTable.readDerivedByIdIdx() ";
		CFBamScopeBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByIdIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_scopedefccbyididx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByIdIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByIdIdx.setLong( argIdx++, Id );
			stmtReadClassCodeByIdIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByIdIdx.getObject( 1 );
			if( resultSet == null ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"rd_scopedefccbyididx() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					classCode = resultSet.getString( 1 );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
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
			if( stmtReadClassCodeByIdIdx != null ) {
				try {
					stmtReadClassCodeByIdIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByIdIdx = null;
			}
		}
		if( classCode.equals( "a801" ) ) {
			buff = readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a802" ) ) {
			buff = schema.getTableSchemaDef().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a804" ) ) {
			buff = schema.getTableSchemaRef().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a805" ) ) {
			buff = schema.getTableServerMethod().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a806" ) ) {
			buff = schema.getTableServerObjFunc().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a807" ) ) {
			buff = schema.getTableServerProc().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a837" ) ) {
			buff = schema.getTableServerListFunc().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a808" ) ) {
			buff = schema.getTableTable().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a810" ) ) {
			buff = schema.getTableClearDep().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a811" ) ) {
			buff = schema.getTableClearSubDep1().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a812" ) ) {
			buff = schema.getTableClearSubDep2().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a813" ) ) {
			buff = schema.getTableClearSubDep3().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a814" ) ) {
			buff = schema.getTableClearTopDep().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a817" ) ) {
			buff = schema.getTableDelDep().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a818" ) ) {
			buff = schema.getTableDelSubDep1().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a819" ) ) {
			buff = schema.getTableDelSubDep2().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a81a" ) ) {
			buff = schema.getTableDelSubDep3().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a81b" ) ) {
			buff = schema.getTableDelTopDep().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a821" ) ) {
			buff = schema.getTableIndex().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a830" ) ) {
			buff = schema.getTablePopDep().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a831" ) ) {
			buff = schema.getTablePopSubDep1().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a832" ) ) {
			buff = schema.getTablePopSubDep2().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a833" ) ) {
			buff = schema.getTablePopSubDep3().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a834" ) ) {
			buff = schema.getTablePopTopDep().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a835" ) ) {
			buff = schema.getTableRelation().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Did not expect ClassCode \"" + classCode + "\"" );
		}
		return( buff );
	}

	public CFBamScopeBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByTenantIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByTenantIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_scopedefccbytenantidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByTenantIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByTenantIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByTenantIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByTenantIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByTenantIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByTenantIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						classCode = resultSet.getString( 1 );
						classCodeList.add( classCode );
					}
				}
				catch( SQLException e ) {
				}
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
			if( stmtReadClassCodeByTenantIdx != null ) {
				try {
					stmtReadClassCodeByTenantIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByTenantIdx = null;
			}
		}
		List<CFBamScopeBuff> resultList = new LinkedList<CFBamScopeBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "a801" ) ) {
				CFBamScopeBuff[] subList
					= readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a802" ) ) {
				CFBamSchemaDefBuff[] subList
					= schema.getTableSchemaDef().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a804" ) ) {
				CFBamSchemaRefBuff[] subList
					= schema.getTableSchemaRef().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a805" ) ) {
				CFBamServerMethodBuff[] subList
					= schema.getTableServerMethod().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a806" ) ) {
				CFBamServerObjFuncBuff[] subList
					= schema.getTableServerObjFunc().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a807" ) ) {
				CFBamServerProcBuff[] subList
					= schema.getTableServerProc().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a837" ) ) {
				CFBamServerListFuncBuff[] subList
					= schema.getTableServerListFunc().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a808" ) ) {
				CFBamTableBuff[] subList
					= schema.getTableTable().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a810" ) ) {
				CFBamClearDepBuff[] subList
					= schema.getTableClearDep().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a811" ) ) {
				CFBamClearSubDep1Buff[] subList
					= schema.getTableClearSubDep1().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a812" ) ) {
				CFBamClearSubDep2Buff[] subList
					= schema.getTableClearSubDep2().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a813" ) ) {
				CFBamClearSubDep3Buff[] subList
					= schema.getTableClearSubDep3().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a814" ) ) {
				CFBamClearTopDepBuff[] subList
					= schema.getTableClearTopDep().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a817" ) ) {
				CFBamDelDepBuff[] subList
					= schema.getTableDelDep().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a818" ) ) {
				CFBamDelSubDep1Buff[] subList
					= schema.getTableDelSubDep1().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a819" ) ) {
				CFBamDelSubDep2Buff[] subList
					= schema.getTableDelSubDep2().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a81a" ) ) {
				CFBamDelSubDep3Buff[] subList
					= schema.getTableDelSubDep3().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a81b" ) ) {
				CFBamDelTopDepBuff[] subList
					= schema.getTableDelTopDep().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a821" ) ) {
				CFBamIndexBuff[] subList
					= schema.getTableIndex().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a830" ) ) {
				CFBamPopDepBuff[] subList
					= schema.getTablePopDep().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a831" ) ) {
				CFBamPopSubDep1Buff[] subList
					= schema.getTablePopSubDep1().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a832" ) ) {
				CFBamPopSubDep2Buff[] subList
					= schema.getTablePopSubDep2().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a833" ) ) {
				CFBamPopSubDep3Buff[] subList
					= schema.getTablePopSubDep3().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a834" ) ) {
				CFBamPopTopDepBuff[] subList
					= schema.getTablePopTopDep().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a835" ) ) {
				CFBamRelationBuff[] subList
					= schema.getTableRelation().readBuffByTenantIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Did not expect ClassCode \"" + classCode + "\"" );
			}
		}
		int idx = 0;
		CFBamScopeBuff[] retBuff = new CFBamScopeBuff[ resultList.size() ];
		Iterator<CFBamScopeBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamScopeBuff readBuff( CFSecAuthorization Authorization,
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

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_scopedef( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamScopeBuff buff = unpackScopeResultSetToBuff( resultSet );
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

	public CFBamScopeBuff lockBuff( CFSecAuthorization Authorization,
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

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_scopedef( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamScopeBuff buff = unpackScopeResultSetToBuff( resultSet );
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

	public CFBamScopeBuff[] readAllBuff( CFSecAuthorization Authorization ) {
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
			CFBamScopeBuff buff = null;
			List<CFBamScopeBuff> buffList = new LinkedList<CFBamScopeBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_scopedefall( ?, ?, ?, ?, ?, ? ) ); end;" );
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
						buff = unpackScopeResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamScopeBuff[] retBuff = new CFBamScopeBuff[ buffList.size() ];
			Iterator<CFBamScopeBuff> iter = buffList.iterator();
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

	public CFBamScopeBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_scopedefbyididx( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamScopeBuff buff = unpackScopeResultSetToBuff( resultSet );
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

	public CFBamScopeBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByTenantIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByTenantIdx = null;
		List<CFBamScopeBuff> buffList = new LinkedList<CFBamScopeBuff>();
		try {
			stmtReadBuffByTenantIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_scopedefbytenantidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamScopeBuff buff = unpackScopeResultSetToBuff( resultSet );
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
			CFBamScopeBuff[] retBuff = new CFBamScopeBuff[ buffList.size() ];
			Iterator<CFBamScopeBuff> iter = buffList.iterator();
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

	public void updateScope( CFSecAuthorization Authorization,
		CFBamScopeBuff Buff )
	{
		final String S_ProcName = "updateScope";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamScopeBuff> buffList = new LinkedList<CFBamScopeBuff>();
		try {			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_scopedef( ?, ?, ?, ?, ?, ?, ?" + ", "
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
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			resultSet = (ResultSet)stmtUpdateByPKey.getObject( 1 );
			if( resultSet != null ) {
				try {
					if( resultSet.next() ) {
						CFBamScopeBuff updatedBuff = unpackScopeResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw new CFLibRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
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
						"upd_scopedef() did not return a valid result cursor" );
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
					"upd_scopedef() did not return a result cursor" );
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

	public void deleteScope( CFSecAuthorization Authorization,
		CFBamScopeBuff Buff )
	{
		final String S_ProcName = "deleteScope";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_scopedef( ?, ?, ?, ?, ?" + ", "
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

	public void deleteScopeByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteScopeByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_scopedefbyididx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteScopeByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		deleteScopeByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteScopeByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteScopeByTenantIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_scopedefbytenantidx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteScopeByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		deleteScopeByTenantIdx( Authorization,
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
		S_sqlSelectScopeBuff = null;
		S_sqlSelectScopeDistinctClassCode = null;

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
		if( stmtReadDerivedClassCode != null ) {
			try {
				stmtReadDerivedClassCode.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadDerivedClassCode = null;
		}
		if( stmtLockDerivedClassCode != null ) {
			try {
				stmtLockDerivedClassCode.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtLockDerivedClassCode = null;
		}
		if( stmtReadAllClassCode != null ) {
			try {
				stmtReadAllClassCode.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadAllClassCode = null;
		}
		if( stmtReadClassCodeByIdIdx != null ) {
			try {
				stmtReadClassCodeByIdIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByIdIdx = null;
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
		if( stmtReadClassCodeByTenantIdx != null ) {
			try {
				stmtReadClassCodeByTenantIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByTenantIdx = null;
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
	}
}
