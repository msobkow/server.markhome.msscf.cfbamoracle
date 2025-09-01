// Description: Java 11 Oracle Jdbc DbIO implementation for PopTopDep.

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
 *	CFBamOraclePopTopDepTable Oracle Jdbc DbIO implementation
 *	for PopTopDep.
 */
public class CFBamOraclePopTopDepTable
	implements ICFBamPopTopDepTable
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
	protected PreparedStatement stmtReadBuffByRelationIdx = null;
	protected PreparedStatement stmtReadBuffByDefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByRelationIdx = null;
	protected PreparedStatement stmtDeleteByDefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByContRelIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtDeleteByContRelIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;

	public CFBamOraclePopTopDepTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createPopTopDep( CFSecAuthorization Authorization,
		CFBamPopTopDepBuff Buff )
	{
		final String S_ProcName = "createPopTopDep";
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			long RelationTenantId = Buff.getRequiredRelationTenantId();
			long RelationId = Buff.getRequiredRelationId();
			long ContRelationTenantId = Buff.getRequiredContRelationTenantId();
			long ContRelationId = Buff.getRequiredContRelationId();
			String Name = Buff.getRequiredName();
			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_pop_topdep( ?, ?, ?, ?, ?, ?, ?" + ", "
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
			stmtCreateByPKey.setLong( argIdx++, RelationTenantId );
			stmtCreateByPKey.setLong( argIdx++, RelationId );
			stmtCreateByPKey.setLong( argIdx++, ContRelationTenantId );
			stmtCreateByPKey.setLong( argIdx++, ContRelationId );
			stmtCreateByPKey.setString( argIdx++, Name );
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"crt_pop_topdep() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamPopTopDepBuff createdBuff = unpackPopTopDepResultSetToBuff( resultSet );
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
				Buff.setOptionalDefSchemaTenantId( createdBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( createdBuff.getOptionalDefSchemaId() );
				Buff.setRequiredRelationTenantId( createdBuff.getRequiredRelationTenantId() );
				Buff.setRequiredRelationId( createdBuff.getRequiredRelationId() );
				Buff.setRequiredContRelationTenantId( createdBuff.getRequiredContRelationTenantId() );
				Buff.setRequiredContRelationId( createdBuff.getRequiredContRelationId() );
				Buff.setRequiredName( createdBuff.getRequiredName() );
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
					"crt_pop_topdep() did not return a valid result set" );
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

	protected static String S_sqlSelectPopTopDepDistinctClassCode = null;

	public String getSqlSelectPopTopDepDistinctClassCode() {
		if( S_sqlSelectPopTopDepDistinctClassCode == null ) {
			S_sqlSelectPopTopDepDistinctClassCode =
					"SELECT "
				+		"DISTINCT a801.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".scopedef a801 "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".pop_dep a830 ON "
				+		"a830.TenantId = a801.TenantId "
				+		"AND a830.Id = a801.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".pop_topdep a834 ON "
				+		"a834.TenantId = a801.TenantId "
				+		"AND a834.Id = a801.Id ";
		}
		return( S_sqlSelectPopTopDepDistinctClassCode );
	}

	protected static String S_sqlSelectPopTopDepBuff = null;

	public String getSqlSelectPopTopDepBuff() {
		if( S_sqlSelectPopTopDepBuff == null ) {
			S_sqlSelectPopTopDepBuff =
					"SELECT "
				+		"a801.ClassCode, "
				+		"a801.TenantId, "
				+		"a801.Id, "
				+		"a830.defschtentid, "
				+		"a830.defschid, "
				+		"a830.RelationTenantId, "
				+		"a830.RelationId, "
				+		"a834.ContRelationTenantId, "
				+		"a834.ContRelationId, "
				+		"a834.safe_name, "
				+		"a801.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".scopedef a801 "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".pop_dep a830 ON "
				+		"a830.TenantId = a801.TenantId "
				+		"AND a830.Id = a801.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".pop_topdep a834 ON "
				+		"a834.TenantId = a801.TenantId "
				+		"AND a834.Id = a801.Id ";
		}
		return( S_sqlSelectPopTopDepBuff );
	}

	protected CFBamPopTopDepBuff unpackPopTopDepResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackPopTopDepResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamPopTopDepBuff buff;
		if( classCode.equals( "a834" ) ) {
			buff = schema.getFactoryPopTopDep().newBuff();
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
		buff.setRequiredRelationTenantId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredRelationId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredContRelationTenantId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredContRelationId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredName( resultSet.getString( idxcol ) );
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamPopTopDepBuff readDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamPopTopDepBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamPopTopDepBuff lockDerived( CFSecAuthorization Authorization,
		CFBamScopePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamPopTopDepBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFBamPopTopDepBuff[] readAllDerived( CFSecAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamPopTopDepBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFBamPopTopDepBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamOraclePopTopDepTable.readDerivedByIdIdx() ";
		CFBamPopTopDepBuff buff;
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

	public CFBamPopTopDepBuff[] readDerivedByTenantIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByTenantIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamPopTopDepBuff[] buffList = readBuffByTenantIdx( Authorization,
				TenantId );
		return( buffList );

	}

	public CFBamPopTopDepBuff[] readDerivedByRelationIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "readDerivedByRelationIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamPopTopDepBuff[] buffList = readBuffByRelationIdx( Authorization,
				RelationTenantId,
				RelationId );
		return( buffList );

	}

	public CFBamPopTopDepBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamPopTopDepBuff[] buffList = readBuffByDefSchemaIdx( Authorization,
				DefSchemaTenantId,
				DefSchemaId );
		return( buffList );

	}

	public CFBamPopTopDepBuff[] readDerivedByContRelIdx( CFSecAuthorization Authorization,
		long ContRelationTenantId,
		long ContRelationId )
	{
		final String S_ProcName = "readDerivedByContRelIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamPopTopDepBuff[] buffList = readBuffByContRelIdx( Authorization,
				ContRelationTenantId,
				ContRelationId );
		return( buffList );

	}

	public CFBamPopTopDepBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long ContRelationTenantId,
		long ContRelationId,
		String Name )
	{
		final String S_ProcName = "CFBamOraclePopTopDepTable.readDerivedByUNameIdx() ";
		CFBamPopTopDepBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				ContRelationTenantId,
				ContRelationId,
				Name );
		return( buff );
	}

	public CFBamPopTopDepBuff readBuff( CFSecAuthorization Authorization,
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

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_pop_topdep( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamPopTopDepBuff buff = unpackPopTopDepResultSetToBuff( resultSet );
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

	public CFBamPopTopDepBuff lockBuff( CFSecAuthorization Authorization,
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

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_pop_topdep( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamPopTopDepBuff buff = unpackPopTopDepResultSetToBuff( resultSet );
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

	public CFBamPopTopDepBuff[] readAllBuff( CFSecAuthorization Authorization ) {
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
			CFBamPopTopDepBuff buff = null;
			List<CFBamPopTopDepBuff> buffList = new LinkedList<CFBamPopTopDepBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_pop_topdepall( ?, ?, ?, ?, ?, ? ) ); end;" );
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
						buff = unpackPopTopDepResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamPopTopDepBuff[] retBuff = new CFBamPopTopDepBuff[ buffList.size() ];
			Iterator<CFBamPopTopDepBuff> iter = buffList.iterator();
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

	public CFBamPopTopDepBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_pop_topdepbyididx( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamPopTopDepBuff buff = unpackPopTopDepResultSetToBuff( resultSet );
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

	public CFBamPopTopDepBuff[] readBuffByTenantIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByTenantIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByTenantIdx = null;
		List<CFBamPopTopDepBuff> buffList = new LinkedList<CFBamPopTopDepBuff>();
		try {
			stmtReadBuffByTenantIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_pop_topdepbytenantidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamPopTopDepBuff buff = unpackPopTopDepResultSetToBuff( resultSet );
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
			CFBamPopTopDepBuff[] retBuff = new CFBamPopTopDepBuff[ buffList.size() ];
			Iterator<CFBamPopTopDepBuff> iter = buffList.iterator();
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

	public CFBamPopTopDepBuff[] readBuffByRelationIdx( CFSecAuthorization Authorization,
		long RelationTenantId,
		long RelationId )
	{
		final String S_ProcName = "readBuffByRelationIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByRelationIdx = null;
		List<CFBamPopTopDepBuff> buffList = new LinkedList<CFBamPopTopDepBuff>();
		try {
			stmtReadBuffByRelationIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_pop_topdepbyrelationidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByRelationIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByRelationIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByRelationIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByRelationIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByRelationIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByRelationIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByRelationIdx.setLong( argIdx++, RelationTenantId );
			stmtReadBuffByRelationIdx.setLong( argIdx++, RelationId );
			stmtReadBuffByRelationIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByRelationIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamPopTopDepBuff buff = unpackPopTopDepResultSetToBuff( resultSet );
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
			CFBamPopTopDepBuff[] retBuff = new CFBamPopTopDepBuff[ buffList.size() ];
			Iterator<CFBamPopTopDepBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByRelationIdx != null ) {
				try {
					stmtReadBuffByRelationIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByRelationIdx = null;
			}
		}
	}

	public CFBamPopTopDepBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readBuffByDefSchemaIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByDefSchemaIdx = null;
		List<CFBamPopTopDepBuff> buffList = new LinkedList<CFBamPopTopDepBuff>();
		try {
			stmtReadBuffByDefSchemaIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_pop_topdepbydefschemaidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamPopTopDepBuff buff = unpackPopTopDepResultSetToBuff( resultSet );
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
			CFBamPopTopDepBuff[] retBuff = new CFBamPopTopDepBuff[ buffList.size() ];
			Iterator<CFBamPopTopDepBuff> iter = buffList.iterator();
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

	public CFBamPopTopDepBuff[] readBuffByContRelIdx( CFSecAuthorization Authorization,
		long ContRelationTenantId,
		long ContRelationId )
	{
		final String S_ProcName = "readBuffByContRelIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByContRelIdx = null;
		List<CFBamPopTopDepBuff> buffList = new LinkedList<CFBamPopTopDepBuff>();
		try {
			stmtReadBuffByContRelIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_pop_topdepbycontrelidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByContRelIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByContRelIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContRelIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByContRelIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByContRelIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContRelIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByContRelIdx.setLong( argIdx++, ContRelationTenantId );
			stmtReadBuffByContRelIdx.setLong( argIdx++, ContRelationId );
			stmtReadBuffByContRelIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByContRelIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamPopTopDepBuff buff = unpackPopTopDepResultSetToBuff( resultSet );
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
			CFBamPopTopDepBuff[] retBuff = new CFBamPopTopDepBuff[ buffList.size() ];
			Iterator<CFBamPopTopDepBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByContRelIdx != null ) {
				try {
					stmtReadBuffByContRelIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByContRelIdx = null;
			}
		}
	}

	public CFBamPopTopDepBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long ContRelationTenantId,
		long ContRelationId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByUNameIdx = null;
		try {
			stmtReadBuffByUNameIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_pop_topdepbyunameidx( ?, ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByUNameIdx.setLong( argIdx++, ContRelationTenantId );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ContRelationId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			stmtReadBuffByUNameIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByUNameIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamPopTopDepBuff buff = unpackPopTopDepResultSetToBuff( resultSet );
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

	public void updatePopTopDep( CFSecAuthorization Authorization,
		CFBamPopTopDepBuff Buff )
	{
		final String S_ProcName = "updatePopTopDep";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamPopTopDepBuff> buffList = new LinkedList<CFBamPopTopDepBuff>();
		try {			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			long RelationTenantId = Buff.getRequiredRelationTenantId();
			long RelationId = Buff.getRequiredRelationId();
			long ContRelationTenantId = Buff.getRequiredContRelationTenantId();
			long ContRelationId = Buff.getRequiredContRelationId();
			String Name = Buff.getRequiredName();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_pop_topdep( ?, ?, ?, ?, ?, ?, ?" + ", "
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
			stmtUpdateByPKey.setLong( argIdx++, RelationTenantId );
			stmtUpdateByPKey.setLong( argIdx++, RelationId );
			stmtUpdateByPKey.setLong( argIdx++, ContRelationTenantId );
			stmtUpdateByPKey.setLong( argIdx++, ContRelationId );
			stmtUpdateByPKey.setString( argIdx++, Name );
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			resultSet = (ResultSet)stmtUpdateByPKey.getObject( 1 );
			if( resultSet != null ) {
				try {
					if( resultSet.next() ) {
						CFBamPopTopDepBuff updatedBuff = unpackPopTopDepResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw new CFLibRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
				Buff.setOptionalDefSchemaTenantId( updatedBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( updatedBuff.getOptionalDefSchemaId() );
				Buff.setRequiredRelationTenantId( updatedBuff.getRequiredRelationTenantId() );
				Buff.setRequiredRelationId( updatedBuff.getRequiredRelationId() );
				Buff.setRequiredContRelationTenantId( updatedBuff.getRequiredContRelationTenantId() );
				Buff.setRequiredContRelationId( updatedBuff.getRequiredContRelationId() );
				Buff.setRequiredName( updatedBuff.getRequiredName() );
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
						"upd_pop_topdep() did not return a valid result cursor" );
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
					"upd_pop_topdep() did not return a result cursor" );
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

	public void deletePopTopDep( CFSecAuthorization Authorization,
		CFBamPopTopDepBuff Buff )
	{
		final String S_ProcName = "deletePopTopDep";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_pop_topdep( ?, ?, ?, ?, ?" + ", "
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

	public void deletePopTopDepByContRelIdx( CFSecAuthorization Authorization,
		long argContRelationTenantId,
		long argContRelationId )
	{
		final String S_ProcName = "deletePopTopDepByContRelIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_pop_topdepbycontrelidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByContRelIdx == null ) {
					stmtDeleteByContRelIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByContRelIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContRelIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByContRelIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByContRelIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContRelIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByContRelIdx.setLong( argIdx++, argContRelationTenantId );
				stmtDeleteByContRelIdx.setLong( argIdx++, argContRelationId );
				int rowsUpdated = stmtDeleteByContRelIdx.executeUpdate();
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

	public void deletePopTopDepByContRelIdx( CFSecAuthorization Authorization,
		CFBamPopTopDepByContRelIdxKey argKey )
	{
		deletePopTopDepByContRelIdx( Authorization,
			argKey.getRequiredContRelationTenantId(),
			argKey.getRequiredContRelationId() );
	}

	public void deletePopTopDepByUNameIdx( CFSecAuthorization Authorization,
		long argContRelationTenantId,
		long argContRelationId,
		String argName )
	{
		final String S_ProcName = "deletePopTopDepByUNameIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_pop_topdepbyunameidx( ?, ?, ?, ?, ?" + ", "
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
				stmtDeleteByUNameIdx.setLong( argIdx++, argContRelationTenantId );
				stmtDeleteByUNameIdx.setLong( argIdx++, argContRelationId );
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

	public void deletePopTopDepByUNameIdx( CFSecAuthorization Authorization,
		CFBamPopTopDepByUNameIdxKey argKey )
	{
		deletePopTopDepByUNameIdx( Authorization,
			argKey.getRequiredContRelationTenantId(),
			argKey.getRequiredContRelationId(),
			argKey.getRequiredName() );
	}

	public void deletePopTopDepByRelationIdx( CFSecAuthorization Authorization,
		long argRelationTenantId,
		long argRelationId )
	{
		final String S_ProcName = "deletePopTopDepByRelationIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_pop_topdepbyrelationidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByRelationIdx == null ) {
					stmtDeleteByRelationIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByRelationIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByRelationIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByRelationIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByRelationIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByRelationIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByRelationIdx.setLong( argIdx++, argRelationTenantId );
				stmtDeleteByRelationIdx.setLong( argIdx++, argRelationId );
				int rowsUpdated = stmtDeleteByRelationIdx.executeUpdate();
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

	public void deletePopTopDepByRelationIdx( CFSecAuthorization Authorization,
		CFBamPopDepByRelationIdxKey argKey )
	{
		deletePopTopDepByRelationIdx( Authorization,
			argKey.getRequiredRelationTenantId(),
			argKey.getRequiredRelationId() );
	}

	public void deletePopTopDepByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		final String S_ProcName = "deletePopTopDepByDefSchemaIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_pop_topdepbydefschemaidx( ?, ?, ?, ?, ?" + ", "
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

	public void deletePopTopDepByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamPopDepByDefSchemaIdxKey argKey )
	{
		deletePopTopDepByDefSchemaIdx( Authorization,
			argKey.getOptionalDefSchemaTenantId(),
			argKey.getOptionalDefSchemaId() );
	}

	public void deletePopTopDepByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deletePopTopDepByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_pop_topdepbyididx( ?, ?, ?, ?, ?" + ", "
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

	public void deletePopTopDepByIdIdx( CFSecAuthorization Authorization,
		CFBamScopePKey argKey )
	{
		deletePopTopDepByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deletePopTopDepByTenantIdx( CFSecAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deletePopTopDepByTenantIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_pop_topdepbytenantidx( ?, ?, ?, ?, ?" + ", "
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

	public void deletePopTopDepByTenantIdx( CFSecAuthorization Authorization,
		CFBamScopeByTenantIdxKey argKey )
	{
		deletePopTopDepByTenantIdx( Authorization,
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
		S_sqlSelectPopTopDepBuff = null;
		S_sqlSelectPopTopDepDistinctClassCode = null;

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
		if( stmtDeleteByRelationIdx != null ) {
			try {
				stmtDeleteByRelationIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByRelationIdx = null;
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByDefSchemaIdx = null;
		}
		if( stmtDeleteByContRelIdx != null ) {
			try {
				stmtDeleteByContRelIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByContRelIdx = null;
		}
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByUNameIdx = null;
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
		if( stmtReadBuffByRelationIdx != null ) {
			try {
				stmtReadBuffByRelationIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByRelationIdx = null;
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
		if( stmtDeleteByRelationIdx != null ) {
			try {
				stmtDeleteByRelationIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByRelationIdx = null;
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
		if( stmtReadBuffByContRelIdx != null ) {
			try {
				stmtReadBuffByContRelIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByContRelIdx = null;
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
		if( stmtDeleteByContRelIdx != null ) {
			try {
				stmtDeleteByContRelIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByContRelIdx = null;
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
	}
}
