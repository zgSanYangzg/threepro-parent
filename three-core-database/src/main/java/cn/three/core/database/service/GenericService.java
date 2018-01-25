package cn.three.core.database.service;

/**
 * 
 * <pre>
 * 
 *  freeapis
 *  File: GenericService.java
 * 
 *  freeapis, Inc.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 *  $Id: GenericService.java 31101200-9 2014-10-14 16:43:51Z freeapis\yangbochao $
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  2015年8月21日		yangbochao		Initial.
 *
 * </pre>
 */
public interface GenericService<M, P> {
	M create(M model) throws Exception;

	String delete(String... id) throws Exception;

	M update(M model) throws Exception;

	M get(String id) throws Exception;
}

/*
 * $Log: av-env.bat,v $
 */