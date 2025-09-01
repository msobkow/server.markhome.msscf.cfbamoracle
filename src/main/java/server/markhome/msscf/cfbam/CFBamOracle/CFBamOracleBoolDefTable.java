// Description: Java 11 Oracle Jdbc DbIO implementation for BoolDef.

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
 *	CFBamOracleBoolDefTable Oracle Jdbc DbIO implementation
 *	for BoolDef.
 */
public class CFBamOracleBoolDefTable
	implements ICFBamBoolDefTable
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
	protected PreparedStatement stmtReadClassCodeByUNameIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtReadClassCodeByValTentIdx = null;
	protected PreparedStatement stmtReadBuffByValTentIdx = null;
	protected PreparedStatement stmtReadClassCodeByScopeIdx = null;
	protected PreparedStatement stmtReadBuffByScopeIdx = null;
	protected PreparedStatement stmtReadClassCodeByDefSchemaIdx = null;
	protected PreparedStatement stmtReadBuffByDefSchemaIdx = null;
	protected PreparedStatement stmtReadClassCodeByPrevIdx = null;
	protected PreparedStatement stmtReadBuffByPrevIdx = null;
	protected PreparedStatement stmtReadClassCodeByNextIdx = null;
	protected PreparedStatement stmtReadBuffByNextIdx = null;
	protected PreparedStatement stmtReadClassCodeByContPrevIdx = null;
	protected PreparedStatement stmtReadBuffByContPrevIdx = null;
	protected PreparedStatement stmtReadClassCodeByContNextIdx = null;
	protected PreparedStatement stmtReadBuffByContNextIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtDeleteByValTentIdx = null;
	protected PreparedStatement stmtDeleteByScopeIdx = null;
	protected PreparedStatement stmtDeleteByDefSchemaIdx = null;
	protected PreparedStatement stmtDeleteByPrevIdx = null;
	protected PreparedStatement stmtDeleteByNextIdx = null;
	protected PreparedStatement stmtDeleteByContPrevIdx = null;
	protected PreparedStatement stmtDeleteByContNextIdx = null;

	public CFBamOracleBoolDefTable( CFBamOracleSchema argSchema ) {
		schema = argSchema;
	}

	public void createBoolDef( CFSecAuthorization Authorization,
		CFBamBoolDefBuff Buff )
	{
		final String S_ProcName = "createBoolDef";
		ResultSet resultSet = null;
		CallableStatement stmtCreateByPKey = null;
		try {
			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long ScopeId = Buff.getRequiredScopeId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			String Name = Buff.getRequiredName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			String DefaultXmlValue = Buff.getOptionalDefaultXmlValue();
			boolean IsNullable = Buff.getRequiredIsNullable();
			Boolean GenerateId = Buff.getOptionalGenerateId();
			boolean ImplementsPolymorph = Buff.getRequiredImplementsPolymorph();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			String DbName = Buff.getOptionalDbName();
			Boolean InitValue = Buff.getOptionalInitValue();
			String FalseString = Buff.getOptionalFalseString();
			String TrueString = Buff.getOptionalTrueString();
			String NullString = Buff.getOptionalNullString();
			Connection cnx = schema.getCnx();
			stmtCreateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".crt_booldef( ?, ?, ?, ?, ?, ?, ?" + ", "
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
			stmtCreateByPKey.setLong( argIdx++, ScopeId );
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
			if( DefaultXmlValue != null ) {
				stmtCreateByPKey.setString( argIdx++, DefaultXmlValue );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( IsNullable ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
			if( GenerateId != null ) {
				if( GenerateId.booleanValue() ) {
					stmtCreateByPKey.setString( argIdx++, "Y" );
				}
				else {
					stmtCreateByPKey.setString( argIdx++, "N" );
				}
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ImplementsPolymorph ) {
				stmtCreateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtCreateByPKey.setString( argIdx++, "N" );
			}
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
			if( DbName != null ) {
				stmtCreateByPKey.setString( argIdx++, DbName );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( InitValue != null ) {
				if( InitValue.booleanValue() ) {
					stmtCreateByPKey.setString( argIdx++, "Y" );
				}
				else {
					stmtCreateByPKey.setString( argIdx++, "N" );
				}
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( FalseString != null ) {
				stmtCreateByPKey.setString( argIdx++, FalseString );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( TrueString != null ) {
				stmtCreateByPKey.setString( argIdx++, TrueString );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( NullString != null ) {
				stmtCreateByPKey.setString( argIdx++, NullString );
			}
			else {
				stmtCreateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtCreateByPKey.execute();
			resultSet = (ResultSet)stmtCreateByPKey.getObject( 1 );
			if( resultSet == null ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"crt_booldef() did not return a result set" );
			}
			try {
				if( resultSet.next() ) {
					CFBamBoolDefBuff createdBuff = unpackBoolDefResultSetToBuff( resultSet );
					if( resultSet.next() ) {
						resultSet.last();
						throw new CFLibRuntimeException( getClass(),
							S_ProcName,
							"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
					}
				Buff.setRequiredTenantId( createdBuff.getRequiredTenantId() );
				Buff.setRequiredScopeId( createdBuff.getRequiredScopeId() );
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setOptionalDefSchemaTenantId( createdBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( createdBuff.getOptionalDefSchemaId() );
				Buff.setRequiredName( createdBuff.getRequiredName() );
				Buff.setOptionalShortName( createdBuff.getOptionalShortName() );
				Buff.setOptionalLabel( createdBuff.getOptionalLabel() );
				Buff.setOptionalShortDescription( createdBuff.getOptionalShortDescription() );
				Buff.setOptionalDescription( createdBuff.getOptionalDescription() );
				Buff.setOptionalDefaultXmlValue( createdBuff.getOptionalDefaultXmlValue() );
				Buff.setRequiredIsNullable( createdBuff.getRequiredIsNullable() );
				Buff.setOptionalGenerateId( createdBuff.getOptionalGenerateId() );
				Buff.setRequiredImplementsPolymorph( createdBuff.getRequiredImplementsPolymorph() );
				Buff.setOptionalPrevTenantId( createdBuff.getOptionalPrevTenantId() );
				Buff.setOptionalPrevId( createdBuff.getOptionalPrevId() );
				Buff.setOptionalNextTenantId( createdBuff.getOptionalNextTenantId() );
				Buff.setOptionalNextId( createdBuff.getOptionalNextId() );
				Buff.setRequiredRevision( createdBuff.getRequiredRevision() );
				Buff.setCreatedByUserId( createdBuff.getCreatedByUserId() );
				Buff.setCreatedAt( createdBuff.getCreatedAt() );
				Buff.setUpdatedByUserId( createdBuff.getUpdatedByUserId() );
				Buff.setUpdatedAt( createdBuff.getUpdatedAt() );
				Buff.setOptionalDbName( createdBuff.getOptionalDbName() );
				Buff.setOptionalInitValue( createdBuff.getOptionalInitValue() );
				Buff.setOptionalFalseString( createdBuff.getOptionalFalseString() );
				Buff.setOptionalTrueString( createdBuff.getOptionalTrueString() );
				Buff.setOptionalNullString( createdBuff.getOptionalNullString() );
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
					"crt_booldef() did not return a valid result set" );
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

	protected static String S_sqlSelectBoolDefDistinctClassCode = null;

	public String getSqlSelectBoolDefDistinctClassCode() {
		if( S_sqlSelectBoolDefDistinctClassCode == null ) {
			S_sqlSelectBoolDefDistinctClassCode =
					"SELECT "
				+		"DISTINCT a809.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".valdef a809 "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".atomdef a80a ON "
				+		"a80a.TenantId = a809.TenantId "
				+		"AND a80a.Id = a809.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".booldef a80d ON "
				+		"a80d.TenantId = a809.TenantId "
				+		"AND a80d.Id = a809.Id ";
		}
		return( S_sqlSelectBoolDefDistinctClassCode );
	}

	protected static String S_sqlSelectBoolDefBuff = null;

	public String getSqlSelectBoolDefBuff() {
		if( S_sqlSelectBoolDefBuff == null ) {
			S_sqlSelectBoolDefBuff =
					"SELECT "
				+		"a809.ClassCode, "
				+		"a809.TenantId, "
				+		"a809.Id, "
				+		"a809.ScopeId, "
				+		"a809.defschtentid, "
				+		"a809.defschid, "
				+		"a809.safe_name, "
				+		"a809.short_name, "
				+		"a809.Label, "
				+		"a809.short_descr, "
				+		"a809.descr, "
				+		"a809.dflt_xml_val, "
				+		"a809.IsNullable, "
				+		"a809.GenerateId, "
				+		"a809.ImplementsPolymorph, "
				+		"a809.PrevTenantId, "
				+		"a809.PrevId, "
				+		"a809.NextTenantId, "
				+		"a809.NextId, "
				+		"a80a.DbName, "
				+		"a80d.InitVal, "
				+		"a80d.FalseString, "
				+		"a80d.TrueString, "
				+		"a80d.NullString, "
				+		"a809.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".valdef a809 "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".atomdef a80a ON "
				+		"a80a.TenantId = a809.TenantId "
				+		"AND a80a.Id = a809.Id "
				+	"INNER JOIN " + schema.getLowerDbSchemaName() + ".booldef a80d ON "
				+		"a80d.TenantId = a809.TenantId "
				+		"AND a80d.Id = a809.Id ";
		}
		return( S_sqlSelectBoolDefBuff );
	}

	protected CFBamBoolDefBuff unpackBoolDefResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackBoolDefResultSetToBuff";
		int idxcol = 1;
		String classCode = resultSet.getString( idxcol );
		idxcol++;
		CFBamBoolDefBuff buff;
		if( classCode.equals( "a80d" ) ) {
			buff = schema.getFactoryBoolDef().newBuff();
		}
		else if( classCode.equals( "a80e" ) ) {
			buff = schema.getFactoryBoolType().newBuff();
		}
		else if( classCode.equals( "a853" ) ) {
			buff = schema.getFactoryBoolCol().newBuff();
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
		buff.setRequiredScopeId( resultSet.getLong( idxcol ) );
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
		buff.setRequiredName( resultSet.getString( idxcol ) );
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
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalDefaultXmlValue( null );
			}
			else {
				buff.setOptionalDefaultXmlValue( colVal );
			}
		}
		idxcol++;
		buff.setRequiredIsNullable( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
		idxcol++;
		{
			boolean colVal = ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false );
			if( resultSet.wasNull() ) {
				buff.setOptionalGenerateId( null );
			}
			else {
				buff.setOptionalGenerateId( colVal );
			}
		}
		idxcol++;
		buff.setRequiredImplementsPolymorph( ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false ) );
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
			boolean colVal = ( "Y".equals( resultSet.getString( idxcol ) ) ? true : false );
			if( resultSet.wasNull() ) {
				buff.setOptionalInitValue( null );
			}
			else {
				buff.setOptionalInitValue( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalFalseString( null );
			}
			else {
				buff.setOptionalFalseString( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalTrueString( null );
			}
			else {
				buff.setOptionalTrueString( colVal );
			}
		}
		idxcol++;
		{
			String colVal = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setOptionalNullString( null );
			}
			else {
				buff.setOptionalNullString( colVal );
			}
		}
		idxcol++;
		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFBamBoolDefBuff readDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamBoolDefBuff buff;

		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadDerivedClassCode = null;
		try {
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			Connection cnx = schema.getCnx();
			stmtReadDerivedClassCode = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefcc( ?, ?, ?, ?, ?, ?" + ", "
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
					"rd_booldefcc() did not return a result set" );
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
		if( classCode.equals( "a80d" ) ) {
			buff = readBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a80e" ) ) {
			buff = schema.getTableBoolType().readBuffByIdIdx( Authorization,
				PKey.getRequiredTenantId(),
				PKey.getRequiredId() );
		}
		else if( classCode.equals( "a853" ) ) {
			buff = schema.getTableBoolCol().readBuffByIdIdx( Authorization,
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

	public CFBamBoolDefBuff lockDerived( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFBamBoolDefBuff buff;
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtLockDerivedClassCode = null;
		try {
			long TenantId = PKey.getRequiredTenantId();
			long Id = PKey.getRequiredId();
			Connection cnx = schema.getCnx();
			stmtLockDerivedClassCode = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefcc( ?, ?, ?, ?, ?, ?" + ", "
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
					"rd_booldefcc() did not return a result set" );
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
		if( classCode.equals( "a80d" ) ) {
			buff = lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a80e" ) ) {
			buff = schema.getTableBoolType().lockBuff( Authorization, PKey );
		}
		else if( classCode.equals( "a853" ) ) {
			buff = schema.getTableBoolCol().lockBuff( Authorization, PKey );
		}
		else {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Did not expect ClassCode \"" + classCode + "\"" );
		}
		return( buff );
	}

	public CFBamBoolDefBuff[] readAllDerived( CFSecAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFBamBoolDefBuff[] buffArray;
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
			stmtReadAllClassCode = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccall( ?, ?, ?, ?, ?, ? ); end;" );
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
		List<CFBamBoolDefBuff> resultList = new LinkedList<CFBamBoolDefBuff>();
		for( int classCodeIdx = 0; classCodeIdx < classCodeList.size(); classCodeIdx ++ ) {
			CFBamBoolDefBuff[] subList;
			classCode = classCodeList.get( classCodeIdx );
			if( classCode.equals( "a80d" ) ) {
				subList = readAllBuff( Authorization );
			}
			else if( classCode.equals( "a80e" ) ) {
				subList = schema.getTableBoolType().readAllBuff( Authorization );
			}
			else if( classCode.equals( "a853" ) ) {
				subList = schema.getTableBoolCol().readAllBuff( Authorization );
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
		buffArray = new CFBamBoolDefBuff[ resultList.size() ];
		Iterator<CFBamBoolDefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			buffArray[idx++] = iter.next();
		}
		return( buffArray );
	}

	public CFBamBoolDefBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "CFBamOracleBoolDefTable.readDerivedByIdIdx() ";
		CFBamBoolDefBuff buff;
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
			stmtReadClassCodeByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccbyididx( ?, ?, ?, ?, ?, ?" + ", "
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
					"rd_booldefccbyididx() did not return a result set" );
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
		if( classCode.equals( "a80d" ) ) {
			buff = readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a80e" ) ) {
			buff = schema.getTableBoolType().readBuffByIdIdx( Authorization,
				TenantId,
				Id );
		}
		else if( classCode.equals( "a853" ) ) {
			buff = schema.getTableBoolCol().readBuffByIdIdx( Authorization,
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

	public CFBamBoolDefBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "CFBamOracleBoolDefTable.readDerivedByUNameIdx() ";
		CFBamBoolDefBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByUNameIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByUNameIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccbyunameidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByUNameIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByUNameIdx.setLong( argIdx++, ScopeId );
			stmtReadClassCodeByUNameIdx.setString( argIdx++, Name );
			stmtReadClassCodeByUNameIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByUNameIdx.getObject( 1 );
			if( resultSet == null ) {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"rd_booldefccbyunameidx() did not return a result set" );
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
			if( stmtReadClassCodeByUNameIdx != null ) {
				try {
					stmtReadClassCodeByUNameIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByUNameIdx = null;
			}
		}
		if( classCode.equals( "a80d" ) ) {
			buff = readBuffByUNameIdx( Authorization,
				TenantId,
				ScopeId,
				Name );
		}
		else if( classCode.equals( "a80e" ) ) {
			buff = schema.getTableBoolType().readBuffByUNameIdx( Authorization,
				TenantId,
				ScopeId,
				Name );
		}
		else if( classCode.equals( "a853" ) ) {
			buff = schema.getTableBoolCol().readBuffByUNameIdx( Authorization,
				TenantId,
				ScopeId,
				Name );
		}
		else {
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Did not expect ClassCode \"" + classCode + "\"" );
		}
		return( buff );
	}

	public CFBamBoolDefBuff[] readDerivedByValTentIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readDerivedByValTentIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByValTentIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByValTentIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccbyvaltentidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByValTentIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByValTentIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByValTentIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByValTentIdx.getObject( 1 );
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
			if( stmtReadClassCodeByValTentIdx != null ) {
				try {
					stmtReadClassCodeByValTentIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByValTentIdx = null;
			}
		}
		List<CFBamBoolDefBuff> resultList = new LinkedList<CFBamBoolDefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "a80d" ) ) {
				CFBamBoolDefBuff[] subList
					= readBuffByValTentIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a80e" ) ) {
				CFBamBoolTypeBuff[] subList
					= schema.getTableBoolType().readBuffByValTentIdx( Authorization,
						TenantId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a853" ) ) {
				CFBamBoolColBuff[] subList
					= schema.getTableBoolCol().readBuffByValTentIdx( Authorization,
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
		CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ resultList.size() ];
		Iterator<CFBamBoolDefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamBoolDefBuff[] readDerivedByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "readDerivedByScopeIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByScopeIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByScopeIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccbyscopeidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByScopeIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByScopeIdx.setLong( argIdx++, ScopeId );
			stmtReadClassCodeByScopeIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByScopeIdx.getObject( 1 );
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
			if( stmtReadClassCodeByScopeIdx != null ) {
				try {
					stmtReadClassCodeByScopeIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByScopeIdx = null;
			}
		}
		List<CFBamBoolDefBuff> resultList = new LinkedList<CFBamBoolDefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "a80d" ) ) {
				CFBamBoolDefBuff[] subList
					= readBuffByScopeIdx( Authorization,
						TenantId,
						ScopeId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a80e" ) ) {
				CFBamBoolTypeBuff[] subList
					= schema.getTableBoolType().readBuffByScopeIdx( Authorization,
						TenantId,
						ScopeId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a853" ) ) {
				CFBamBoolColBuff[] subList
					= schema.getTableBoolCol().readBuffByScopeIdx( Authorization,
						TenantId,
						ScopeId );
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
		CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ resultList.size() ];
		Iterator<CFBamBoolDefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamBoolDefBuff[] readDerivedByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readDerivedByDefSchemaIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByDefSchemaIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByDefSchemaIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccbydefschemaidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByDefSchemaIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByDefSchemaIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( DefSchemaTenantId != null ) {
				stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, DefSchemaTenantId.longValue() );
			}
			else {
				stmtReadClassCodeByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( DefSchemaId != null ) {
				stmtReadClassCodeByDefSchemaIdx.setLong( argIdx++, DefSchemaId.longValue() );
			}
			else {
				stmtReadClassCodeByDefSchemaIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByDefSchemaIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByDefSchemaIdx.getObject( 1 );
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
			if( stmtReadClassCodeByDefSchemaIdx != null ) {
				try {
					stmtReadClassCodeByDefSchemaIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByDefSchemaIdx = null;
			}
		}
		List<CFBamBoolDefBuff> resultList = new LinkedList<CFBamBoolDefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "a80d" ) ) {
				CFBamBoolDefBuff[] subList
					= readBuffByDefSchemaIdx( Authorization,
						DefSchemaTenantId,
						DefSchemaId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a80e" ) ) {
				CFBamBoolTypeBuff[] subList
					= schema.getTableBoolType().readBuffByDefSchemaIdx( Authorization,
						DefSchemaTenantId,
						DefSchemaId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a853" ) ) {
				CFBamBoolColBuff[] subList
					= schema.getTableBoolCol().readBuffByDefSchemaIdx( Authorization,
						DefSchemaTenantId,
						DefSchemaId );
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
		CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ resultList.size() ];
		Iterator<CFBamBoolDefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamBoolDefBuff[] readDerivedByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readDerivedByPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByPrevIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccbyprevidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByPrevIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( PrevTenantId != null ) {
				stmtReadClassCodeByPrevIdx.setLong( argIdx++, PrevTenantId.longValue() );
			}
			else {
				stmtReadClassCodeByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( PrevId != null ) {
				stmtReadClassCodeByPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtReadClassCodeByPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByPrevIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByPrevIdx.getObject( 1 );
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
			if( stmtReadClassCodeByPrevIdx != null ) {
				try {
					stmtReadClassCodeByPrevIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByPrevIdx = null;
			}
		}
		List<CFBamBoolDefBuff> resultList = new LinkedList<CFBamBoolDefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "a80d" ) ) {
				CFBamBoolDefBuff[] subList
					= readBuffByPrevIdx( Authorization,
						PrevTenantId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a80e" ) ) {
				CFBamBoolTypeBuff[] subList
					= schema.getTableBoolType().readBuffByPrevIdx( Authorization,
						PrevTenantId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a853" ) ) {
				CFBamBoolColBuff[] subList
					= schema.getTableBoolCol().readBuffByPrevIdx( Authorization,
						PrevTenantId,
						PrevId );
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
		CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ resultList.size() ];
		Iterator<CFBamBoolDefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamBoolDefBuff[] readDerivedByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readDerivedByNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByNextIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccbynextidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByNextIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( NextTenantId != null ) {
				stmtReadClassCodeByNextIdx.setLong( argIdx++, NextTenantId.longValue() );
			}
			else {
				stmtReadClassCodeByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			if( NextId != null ) {
				stmtReadClassCodeByNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtReadClassCodeByNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByNextIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByNextIdx.getObject( 1 );
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
			if( stmtReadClassCodeByNextIdx != null ) {
				try {
					stmtReadClassCodeByNextIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByNextIdx = null;
			}
		}
		List<CFBamBoolDefBuff> resultList = new LinkedList<CFBamBoolDefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "a80d" ) ) {
				CFBamBoolDefBuff[] subList
					= readBuffByNextIdx( Authorization,
						NextTenantId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a80e" ) ) {
				CFBamBoolTypeBuff[] subList
					= schema.getTableBoolType().readBuffByNextIdx( Authorization,
						NextTenantId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a853" ) ) {
				CFBamBoolColBuff[] subList
					= schema.getTableBoolCol().readBuffByNextIdx( Authorization,
						NextTenantId,
						NextId );
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
		CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ resultList.size() ];
		Iterator<CFBamBoolDefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamBoolDefBuff[] readDerivedByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "readDerivedByContPrevIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByContPrevIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByContPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccbycontprevidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByContPrevIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByContPrevIdx.setLong( argIdx++, ScopeId );
			if( PrevId != null ) {
				stmtReadClassCodeByContPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtReadClassCodeByContPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByContPrevIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByContPrevIdx.getObject( 1 );
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
			if( stmtReadClassCodeByContPrevIdx != null ) {
				try {
					stmtReadClassCodeByContPrevIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByContPrevIdx = null;
			}
		}
		List<CFBamBoolDefBuff> resultList = new LinkedList<CFBamBoolDefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "a80d" ) ) {
				CFBamBoolDefBuff[] subList
					= readBuffByContPrevIdx( Authorization,
						TenantId,
						ScopeId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a80e" ) ) {
				CFBamBoolTypeBuff[] subList
					= schema.getTableBoolType().readBuffByContPrevIdx( Authorization,
						TenantId,
						ScopeId,
						PrevId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a853" ) ) {
				CFBamBoolColBuff[] subList
					= schema.getTableBoolCol().readBuffByContPrevIdx( Authorization,
						TenantId,
						ScopeId,
						PrevId );
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
		CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ resultList.size() ];
		Iterator<CFBamBoolDefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamBoolDefBuff[] readDerivedByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "readDerivedByContNextIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}

		ArrayList<String> classCodeList = new ArrayList<String>();
		String classCode;
		ResultSet resultSet = null;
		CallableStatement stmtReadClassCodeByContNextIdx = null;
		try {
			Connection cnx = schema.getCnx();
			stmtReadClassCodeByContNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefccbycontnextidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadClassCodeByContNextIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadClassCodeByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, TenantId );
			stmtReadClassCodeByContNextIdx.setLong( argIdx++, ScopeId );
			if( NextId != null ) {
				stmtReadClassCodeByContNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtReadClassCodeByContNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadClassCodeByContNextIdx.execute();
			resultSet = (ResultSet)stmtReadClassCodeByContNextIdx.getObject( 1 );
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
			if( stmtReadClassCodeByContNextIdx != null ) {
				try {
					stmtReadClassCodeByContNextIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadClassCodeByContNextIdx = null;
			}
		}
		List<CFBamBoolDefBuff> resultList = new LinkedList<CFBamBoolDefBuff>();
		ListIterator<String> classCodeIter = classCodeList.listIterator();
		while( classCodeIter.hasNext() ) {
			classCode = classCodeIter.next();
			if( classCode.equals( "a80d" ) ) {
				CFBamBoolDefBuff[] subList
					= readBuffByContNextIdx( Authorization,
						TenantId,
						ScopeId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a80e" ) ) {
				CFBamBoolTypeBuff[] subList
					= schema.getTableBoolType().readBuffByContNextIdx( Authorization,
						TenantId,
						ScopeId,
						NextId );
				for( int subListIdx = 0; subListIdx < subList.length; subListIdx ++ )
				{
					resultList.add( subList[ subListIdx ] );
				}
			}
			else if( classCode.equals( "a853" ) ) {
				CFBamBoolColBuff[] subList
					= schema.getTableBoolCol().readBuffByContNextIdx( Authorization,
						TenantId,
						ScopeId,
						NextId );
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
		CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ resultList.size() ];
		Iterator<CFBamBoolDefBuff> iter = resultList.iterator();
		while( iter.hasNext() ) {
			retBuff[idx++] = iter.next();
		}
		return( retBuff );
	}

	public CFBamBoolDefBuff readBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
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

			stmtReadBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldef( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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

	public CFBamBoolDefBuff lockBuff( CFSecAuthorization Authorization,
		CFBamValuePKey PKey )
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

			stmtLockBuffByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".lck_booldef( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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

	public CFBamBoolDefBuff[] readAllBuff( CFSecAuthorization Authorization ) {
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
			CFBamBoolDefBuff buff = null;
			List<CFBamBoolDefBuff> buffList = new LinkedList<CFBamBoolDefBuff>();
			stmtReadAllBuff = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefall( ?, ?, ?, ?, ?, ? ) ); end;" );
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
						buff = unpackBoolDefResultSetToBuff( resultSet );
						buffList.add( buff );
					}
				}
				catch( SQLException e ) {
					// Oracle may return an invalid resultSet if the rowset is empty
				}
			}
			int idx = 0;
			CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ buffList.size() ];
			Iterator<CFBamBoolDefBuff> iter = buffList.iterator();
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

	public CFBamBoolDefBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByIdIdx = null;
		try {
			stmtReadBuffByIdIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefbyididx( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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

	public CFBamBoolDefBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		String Name )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByUNameIdx = null;
		try {
			stmtReadBuffByUNameIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefbyunameidx( ?, ?, ?, ?, ?, ?" + ", "
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
			stmtReadBuffByUNameIdx.setLong( argIdx++, ScopeId );
			stmtReadBuffByUNameIdx.setString( argIdx++, Name );
			stmtReadBuffByUNameIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByUNameIdx.getObject( 1 );
			if( resultSet == null ) {
				return( null );
			}
			try {
				if( resultSet.next() ) {
					CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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

	public CFBamBoolDefBuff[] readBuffByValTentIdx( CFSecAuthorization Authorization,
		long TenantId )
	{
		final String S_ProcName = "readBuffByValTentIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByValTentIdx = null;
		List<CFBamBoolDefBuff> buffList = new LinkedList<CFBamBoolDefBuff>();
		try {
			stmtReadBuffByValTentIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefbyvaltentidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByValTentIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByValTentIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByValTentIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByValTentIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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
			CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ buffList.size() ];
			Iterator<CFBamBoolDefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByValTentIdx != null ) {
				try {
					stmtReadBuffByValTentIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByValTentIdx = null;
			}
		}
	}

	public CFBamBoolDefBuff[] readBuffByScopeIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId )
	{
		final String S_ProcName = "readBuffByScopeIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByScopeIdx = null;
		List<CFBamBoolDefBuff> buffList = new LinkedList<CFBamBoolDefBuff>();
		try {
			stmtReadBuffByScopeIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefbyscopeidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByScopeIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByScopeIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByScopeIdx.setLong( argIdx++, ScopeId );
			stmtReadBuffByScopeIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByScopeIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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
			CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ buffList.size() ];
			Iterator<CFBamBoolDefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByScopeIdx != null ) {
				try {
					stmtReadBuffByScopeIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByScopeIdx = null;
			}
		}
	}

	public CFBamBoolDefBuff[] readBuffByDefSchemaIdx( CFSecAuthorization Authorization,
		Long DefSchemaTenantId,
		Long DefSchemaId )
	{
		final String S_ProcName = "readBuffByDefSchemaIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByDefSchemaIdx = null;
		List<CFBamBoolDefBuff> buffList = new LinkedList<CFBamBoolDefBuff>();
		try {
			stmtReadBuffByDefSchemaIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefbydefschemaidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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
			CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ buffList.size() ];
			Iterator<CFBamBoolDefBuff> iter = buffList.iterator();
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

	public CFBamBoolDefBuff[] readBuffByPrevIdx( CFSecAuthorization Authorization,
		Long PrevTenantId,
		Long PrevId )
	{
		final String S_ProcName = "readBuffByPrevIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByPrevIdx = null;
		List<CFBamBoolDefBuff> buffList = new LinkedList<CFBamBoolDefBuff>();
		try {
			stmtReadBuffByPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefbyprevidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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
			CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ buffList.size() ];
			Iterator<CFBamBoolDefBuff> iter = buffList.iterator();
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

	public CFBamBoolDefBuff[] readBuffByNextIdx( CFSecAuthorization Authorization,
		Long NextTenantId,
		Long NextId )
	{
		final String S_ProcName = "readBuffByNextIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByNextIdx = null;
		List<CFBamBoolDefBuff> buffList = new LinkedList<CFBamBoolDefBuff>();
		try {
			stmtReadBuffByNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefbynextidx( ?, ?, ?, ?, ?, ?" + ", "
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
						CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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
			CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ buffList.size() ];
			Iterator<CFBamBoolDefBuff> iter = buffList.iterator();
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

	public CFBamBoolDefBuff[] readBuffByContPrevIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long PrevId )
	{
		final String S_ProcName = "readBuffByContPrevIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByContPrevIdx = null;
		List<CFBamBoolDefBuff> buffList = new LinkedList<CFBamBoolDefBuff>();
		try {
			stmtReadBuffByContPrevIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefbycontprevidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByContPrevIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByContPrevIdx.setLong( argIdx++, ScopeId );
			if( PrevId != null ) {
				stmtReadBuffByContPrevIdx.setLong( argIdx++, PrevId.longValue() );
			}
			else {
				stmtReadBuffByContPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByContPrevIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByContPrevIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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
			CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ buffList.size() ];
			Iterator<CFBamBoolDefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByContPrevIdx != null ) {
				try {
					stmtReadBuffByContPrevIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByContPrevIdx = null;
			}
		}
	}

	public CFBamBoolDefBuff[] readBuffByContNextIdx( CFSecAuthorization Authorization,
		long TenantId,
		long ScopeId,
		Long NextId )
	{
		final String S_ProcName = "readBuffByContNextIdx";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtReadBuffByContNextIdx = null;
		List<CFBamBoolDefBuff> buffList = new LinkedList<CFBamBoolDefBuff>();
		try {
			stmtReadBuffByContNextIdx = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".rd_booldefbycontnextidx( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end;" );
			int argIdx = 1;
			stmtReadBuffByContNextIdx.registerOutParameter( argIdx++, OracleTypes.CURSOR );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByContNextIdx.setLong( argIdx++, TenantId );
			stmtReadBuffByContNextIdx.setLong( argIdx++, ScopeId );
			if( NextId != null ) {
				stmtReadBuffByContNextIdx.setLong( argIdx++, NextId.longValue() );
			}
			else {
				stmtReadBuffByContNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			stmtReadBuffByContNextIdx.execute();
			resultSet = (ResultSet)stmtReadBuffByContNextIdx.getObject( 1 );
			if( resultSet != null ) {
				try {
					while( resultSet.next() ) {
						CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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
			CFBamBoolDefBuff[] retBuff = new CFBamBoolDefBuff[ buffList.size() ];
			Iterator<CFBamBoolDefBuff> iter = buffList.iterator();
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
			if( stmtReadBuffByContNextIdx != null ) {
				try {
					stmtReadBuffByContNextIdx.close();
				}
				catch( SQLException e ) {
				}
				stmtReadBuffByContNextIdx = null;
			}
		}
	}

	public void updateBoolDef( CFSecAuthorization Authorization,
		CFBamBoolDefBuff Buff )
	{
		final String S_ProcName = "updateBoolDef";
		ResultSet resultSet = null;
		Connection cnx = schema.getCnx();
		CallableStatement stmtUpdateByPKey = null;
		List<CFBamBoolDefBuff> buffList = new LinkedList<CFBamBoolDefBuff>();
		try {			String ClassCode = Buff.getClassCode();
			long TenantId = Buff.getRequiredTenantId();
			long ScopeId = Buff.getRequiredScopeId();
			long Id = Buff.getRequiredId();
			Long DefSchemaTenantId = Buff.getOptionalDefSchemaTenantId();
			Long DefSchemaId = Buff.getOptionalDefSchemaId();
			String Name = Buff.getRequiredName();
			String ShortName = Buff.getOptionalShortName();
			String Label = Buff.getOptionalLabel();
			String ShortDescription = Buff.getOptionalShortDescription();
			String Description = Buff.getOptionalDescription();
			String DefaultXmlValue = Buff.getOptionalDefaultXmlValue();
			boolean IsNullable = Buff.getRequiredIsNullable();
			Boolean GenerateId = Buff.getOptionalGenerateId();
			boolean ImplementsPolymorph = Buff.getRequiredImplementsPolymorph();
			Long PrevTenantId = Buff.getOptionalPrevTenantId();
			Long PrevId = Buff.getOptionalPrevId();
			Long NextTenantId = Buff.getOptionalNextTenantId();
			Long NextId = Buff.getOptionalNextId();
			String DbName = Buff.getOptionalDbName();
			Boolean InitValue = Buff.getOptionalInitValue();
			String FalseString = Buff.getOptionalFalseString();
			String TrueString = Buff.getOptionalTrueString();
			String NullString = Buff.getOptionalNullString();
			int Revision = Buff.getRequiredRevision();
			stmtUpdateByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".upd_booldef( ?, ?, ?, ?, ?, ?, ?" + ", "
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
			stmtUpdateByPKey.setLong( argIdx++, ScopeId );
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
			stmtUpdateByPKey.setString( argIdx++, Name );
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
			if( DefaultXmlValue != null ) {
				stmtUpdateByPKey.setString( argIdx++, DefaultXmlValue );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( IsNullable ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
			if( GenerateId != null ) {
				if( GenerateId.booleanValue() ) {
					stmtUpdateByPKey.setString( argIdx++, "Y" );
				}
				else {
					stmtUpdateByPKey.setString( argIdx++, "N" );
				}
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( ImplementsPolymorph ) {
				stmtUpdateByPKey.setString( argIdx++, "Y" );
			}
			else {
				stmtUpdateByPKey.setString( argIdx++, "N" );
			}
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
			if( DbName != null ) {
				stmtUpdateByPKey.setString( argIdx++, DbName );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( InitValue != null ) {
				if( InitValue.booleanValue() ) {
					stmtUpdateByPKey.setString( argIdx++, "Y" );
				}
				else {
					stmtUpdateByPKey.setString( argIdx++, "N" );
				}
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( FalseString != null ) {
				stmtUpdateByPKey.setString( argIdx++, FalseString );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( TrueString != null ) {
				stmtUpdateByPKey.setString( argIdx++, TrueString );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			if( NullString != null ) {
				stmtUpdateByPKey.setString( argIdx++, NullString );
			}
			else {
				stmtUpdateByPKey.setNull( argIdx++, java.sql.Types.VARCHAR );
			}
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			stmtUpdateByPKey.execute();
			resultSet = (ResultSet)stmtUpdateByPKey.getObject( 1 );
			if( resultSet != null ) {
				try {
					if( resultSet.next() ) {
						CFBamBoolDefBuff updatedBuff = unpackBoolDefResultSetToBuff( resultSet );
						if( resultSet.next() ) {
							resultSet.last();
							throw new CFLibRuntimeException( getClass(),
								S_ProcName,
								"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
						}
				Buff.setRequiredScopeId( updatedBuff.getRequiredScopeId() );
				Buff.setOptionalDefSchemaTenantId( updatedBuff.getOptionalDefSchemaTenantId() );
				Buff.setOptionalDefSchemaId( updatedBuff.getOptionalDefSchemaId() );
				Buff.setRequiredName( updatedBuff.getRequiredName() );
				Buff.setOptionalShortName( updatedBuff.getOptionalShortName() );
				Buff.setOptionalLabel( updatedBuff.getOptionalLabel() );
				Buff.setOptionalShortDescription( updatedBuff.getOptionalShortDescription() );
				Buff.setOptionalDescription( updatedBuff.getOptionalDescription() );
				Buff.setOptionalDefaultXmlValue( updatedBuff.getOptionalDefaultXmlValue() );
				Buff.setRequiredIsNullable( updatedBuff.getRequiredIsNullable() );
				Buff.setOptionalGenerateId( updatedBuff.getOptionalGenerateId() );
				Buff.setRequiredImplementsPolymorph( updatedBuff.getRequiredImplementsPolymorph() );
				Buff.setOptionalPrevTenantId( updatedBuff.getOptionalPrevTenantId() );
				Buff.setOptionalPrevId( updatedBuff.getOptionalPrevId() );
				Buff.setOptionalNextTenantId( updatedBuff.getOptionalNextTenantId() );
				Buff.setOptionalNextId( updatedBuff.getOptionalNextId() );
				Buff.setOptionalDbName( updatedBuff.getOptionalDbName() );
				Buff.setOptionalInitValue( updatedBuff.getOptionalInitValue() );
				Buff.setOptionalFalseString( updatedBuff.getOptionalFalseString() );
				Buff.setOptionalTrueString( updatedBuff.getOptionalTrueString() );
				Buff.setOptionalNullString( updatedBuff.getOptionalNullString() );
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
						"upd_booldef() did not return a valid result cursor" );
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
					"upd_booldef() did not return a result cursor" );
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

	public void deleteBoolDef( CFSecAuthorization Authorization,
		CFBamBoolDefBuff Buff )
	{
		final String S_ProcName = "deleteBoolDef";
		Connection cnx = schema.getCnx();
		CallableStatement stmtDeleteByPKey = null;
		try {
			long TenantId = Buff.getRequiredTenantId();
			long Id = Buff.getRequiredId();
			stmtDeleteByPKey = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".dl_booldef( ?, ?, ?, ?, ?" + ", "
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

	public void deleteBoolDefByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId )
	{
		final String S_ProcName = "deleteBoolDefByIdIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_booldefbyididx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteBoolDefByIdIdx( CFSecAuthorization Authorization,
		CFBamValuePKey argKey )
	{
		deleteBoolDefByIdIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredId() );
	}

	public void deleteBoolDefByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		String argName )
	{
		final String S_ProcName = "deleteBoolDefByUNameIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_booldefbyunameidx( ?, ?, ?, ?, ?" + ", "
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
				stmtDeleteByUNameIdx.setLong( argIdx++, argScopeId );
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

	public void deleteBoolDefByUNameIdx( CFSecAuthorization Authorization,
		CFBamValueByUNameIdxKey argKey )
	{
		deleteBoolDefByUNameIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredScopeId(),
			argKey.getRequiredName() );
	}

	public void deleteBoolDefByValTentIdx( CFSecAuthorization Authorization,
		long argTenantId )
	{
		final String S_ProcName = "deleteBoolDefByValTentIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_booldefbyvaltentidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByValTentIdx == null ) {
					stmtDeleteByValTentIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByValTentIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByValTentIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByValTentIdx.setLong( argIdx++, argTenantId );
				int rowsUpdated = stmtDeleteByValTentIdx.executeUpdate();
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

	public void deleteBoolDefByValTentIdx( CFSecAuthorization Authorization,
		CFBamValueByValTentIdxKey argKey )
	{
		deleteBoolDefByValTentIdx( Authorization,
			argKey.getRequiredTenantId() );
	}

	public void deleteBoolDefByScopeIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId )
	{
		final String S_ProcName = "deleteBoolDefByScopeIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_booldefbyscopeidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByScopeIdx == null ) {
					stmtDeleteByScopeIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByScopeIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByScopeIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByScopeIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByScopeIdx.setLong( argIdx++, argScopeId );
				int rowsUpdated = stmtDeleteByScopeIdx.executeUpdate();
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

	public void deleteBoolDefByScopeIdx( CFSecAuthorization Authorization,
		CFBamValueByScopeIdxKey argKey )
	{
		deleteBoolDefByScopeIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredScopeId() );
	}

	public void deleteBoolDefByDefSchemaIdx( CFSecAuthorization Authorization,
		Long argDefSchemaTenantId,
		Long argDefSchemaId )
	{
		final String S_ProcName = "deleteBoolDefByDefSchemaIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_booldefbydefschemaidx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteBoolDefByDefSchemaIdx( CFSecAuthorization Authorization,
		CFBamValueByDefSchemaIdxKey argKey )
	{
		deleteBoolDefByDefSchemaIdx( Authorization,
			argKey.getOptionalDefSchemaTenantId(),
			argKey.getOptionalDefSchemaId() );
	}

	public void deleteBoolDefByPrevIdx( CFSecAuthorization Authorization,
		Long argPrevTenantId,
		Long argPrevId )
	{
		final String S_ProcName = "deleteBoolDefByPrevIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_booldefbyprevidx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteBoolDefByPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByPrevIdxKey argKey )
	{
		deleteBoolDefByPrevIdx( Authorization,
			argKey.getOptionalPrevTenantId(),
			argKey.getOptionalPrevId() );
	}

	public void deleteBoolDefByNextIdx( CFSecAuthorization Authorization,
		Long argNextTenantId,
		Long argNextId )
	{
		final String S_ProcName = "deleteBoolDefByNextIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_booldefbynextidx( ?, ?, ?, ?, ?" + ", "
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

	public void deleteBoolDefByNextIdx( CFSecAuthorization Authorization,
		CFBamValueByNextIdxKey argKey )
	{
		deleteBoolDefByNextIdx( Authorization,
			argKey.getOptionalNextTenantId(),
			argKey.getOptionalNextId() );
	}

	public void deleteBoolDefByContPrevIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argPrevId )
	{
		final String S_ProcName = "deleteBoolDefByContPrevIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_booldefbycontprevidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByContPrevIdx == null ) {
					stmtDeleteByContPrevIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByContPrevIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContPrevIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByContPrevIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByContPrevIdx.setLong( argIdx++, argScopeId );
				if( argPrevId != null ) {
					stmtDeleteByContPrevIdx.setLong( argIdx++, argPrevId.longValue() );
				}
				else {
					stmtDeleteByContPrevIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByContPrevIdx.executeUpdate();
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

	public void deleteBoolDefByContPrevIdx( CFSecAuthorization Authorization,
		CFBamValueByContPrevIdxKey argKey )
	{
		deleteBoolDefByContPrevIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredScopeId(),
			argKey.getOptionalPrevId() );
	}

	public void deleteBoolDefByContNextIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argScopeId,
		Long argNextId )
	{
		final String S_ProcName = "deleteBoolDefByContNextIdx";
		ResultSet resultSet = null;
		try {
				Connection cnx = schema.getCnx();
				String sql = "begin call " + schema.getLowerDbSchemaName() + ".dl_booldefbycontnextidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + ", "
				+		"?" + " ); end";
				if( stmtDeleteByContNextIdx == null ) {
					stmtDeleteByContNextIdx = cnx.prepareStatement( sql );
				}
				int argIdx = 1;
				stmtDeleteByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
				stmtDeleteByContNextIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
				stmtDeleteByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
				stmtDeleteByContNextIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
				stmtDeleteByContNextIdx.setLong( argIdx++, argTenantId );
				stmtDeleteByContNextIdx.setLong( argIdx++, argScopeId );
				if( argNextId != null ) {
					stmtDeleteByContNextIdx.setLong( argIdx++, argNextId.longValue() );
				}
				else {
					stmtDeleteByContNextIdx.setNull( argIdx++, java.sql.Types.BIGINT );
				}
				int rowsUpdated = stmtDeleteByContNextIdx.executeUpdate();
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

	public void deleteBoolDefByContNextIdx( CFSecAuthorization Authorization,
		CFBamValueByContNextIdxKey argKey )
	{
		deleteBoolDefByContNextIdx( Authorization,
			argKey.getRequiredTenantId(),
			argKey.getRequiredScopeId(),
			argKey.getOptionalNextId() );
	}

	/**
	 *	Move the specified buffer up in the chain (i.e. to the previous position.)
	 *
	 *	@return	The refreshed buffer after it has been moved
	 */
	public CFBamBoolDefBuff moveBuffUp( CFSecAuthorization Authorization,
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
			stmtMoveUp = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".mvup_booldef( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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
	public CFBamBoolDefBuff moveBuffDown( CFSecAuthorization Authorization,
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
			stmtMoveDown = cnx.prepareCall( "begin " + schema.getLowerDbSchemaName() + ".mvdn_booldef( ?, ?, ?, ?, ?, ?" + ", "
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
					CFBamBoolDefBuff buff = unpackBoolDefResultSetToBuff( resultSet );
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
		S_sqlSelectBoolDefBuff = null;
		S_sqlSelectBoolDefDistinctClassCode = null;

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
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByUNameIdx = null;
		}
		if( stmtDeleteByValTentIdx != null ) {
			try {
				stmtDeleteByValTentIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByValTentIdx = null;
		}
		if( stmtDeleteByScopeIdx != null ) {
			try {
				stmtDeleteByScopeIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByScopeIdx = null;
		}
		if( stmtDeleteByDefSchemaIdx != null ) {
			try {
				stmtDeleteByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByDefSchemaIdx = null;
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
		if( stmtDeleteByContPrevIdx != null ) {
			try {
				stmtDeleteByContPrevIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByContPrevIdx = null;
		}
		if( stmtDeleteByContNextIdx != null ) {
			try {
				stmtDeleteByContNextIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByContNextIdx = null;
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
		if( stmtReadClassCodeByUNameIdx != null ) {
			try {
				stmtReadClassCodeByUNameIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByUNameIdx = null;
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
		if( stmtReadClassCodeByValTentIdx != null ) {
			try {
				stmtReadClassCodeByValTentIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByValTentIdx = null;
		}
		if( stmtReadBuffByValTentIdx != null ) {
			try {
				stmtReadBuffByValTentIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByValTentIdx = null;
		}
		if( stmtReadClassCodeByScopeIdx != null ) {
			try {
				stmtReadClassCodeByScopeIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByScopeIdx = null;
		}
		if( stmtReadBuffByScopeIdx != null ) {
			try {
				stmtReadBuffByScopeIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByScopeIdx = null;
		}
		if( stmtReadClassCodeByDefSchemaIdx != null ) {
			try {
				stmtReadClassCodeByDefSchemaIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByDefSchemaIdx = null;
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
		if( stmtReadClassCodeByPrevIdx != null ) {
			try {
				stmtReadClassCodeByPrevIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByPrevIdx = null;
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
		if( stmtReadClassCodeByNextIdx != null ) {
			try {
				stmtReadClassCodeByNextIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByNextIdx = null;
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
		if( stmtReadClassCodeByContPrevIdx != null ) {
			try {
				stmtReadClassCodeByContPrevIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByContPrevIdx = null;
		}
		if( stmtReadBuffByContPrevIdx != null ) {
			try {
				stmtReadBuffByContPrevIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByContPrevIdx = null;
		}
		if( stmtReadClassCodeByContNextIdx != null ) {
			try {
				stmtReadClassCodeByContNextIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadClassCodeByContNextIdx = null;
		}
		if( stmtReadBuffByContNextIdx != null ) {
			try {
				stmtReadBuffByContNextIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtReadBuffByContNextIdx = null;
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
		if( stmtDeleteByValTentIdx != null ) {
			try {
				stmtDeleteByValTentIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByValTentIdx = null;
		}
		if( stmtDeleteByScopeIdx != null ) {
			try {
				stmtDeleteByScopeIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByScopeIdx = null;
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
		if( stmtDeleteByContPrevIdx != null ) {
			try {
				stmtDeleteByContPrevIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByContPrevIdx = null;
		}
		if( stmtDeleteByContNextIdx != null ) {
			try {
				stmtDeleteByContNextIdx.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtDeleteByContNextIdx = null;
		}
	}
}
