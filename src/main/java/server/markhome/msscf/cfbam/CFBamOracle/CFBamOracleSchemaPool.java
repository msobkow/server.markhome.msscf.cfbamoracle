// Description: Java 11 implementation of an Oracle CFBam schema pool.

/*
 *	server.markhome.msscf.CFBam
 *
 *	Copyright (c) 2020-2025 Mark Stephen Sobkow
 *	
 *
 *	Manufactured by MSS Code Factory 2.13
 */

package server.markhome.msscf.cfbam.CFBamOracle;

import java.util.*;

import org.msscf.msscf.cflib.CFLib.*;
import server.markhome.msscf.cfsec.CFSec.*;
import server.markhome.msscf.cfint.CFInt.*;
import server.markhome.msscf.cfbam.CFBam.*;

public class CFBamOracleSchemaPool
extends CFBamSchemaPool
{
	public CFBamOracleSchemaPool() {
		setJndiName( "java:comp/env/CFBam31ConnectionPool" );
	}

	/**
	 *	You need to overload the implementation of newInstance() to return
	 *	connected instances of your backing store.
	 */
	public ICFBamSchema newInstance() {
		ICFBamSchema inst = new CFBamOracleSchema();
		return( inst );
	}
}
