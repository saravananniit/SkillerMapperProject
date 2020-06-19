package com.niit.MemCacheDemo;

/**
 * Hello world!
 *
 */

import java.util.HashMap;
import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
		//initialize the SockIOPool that maintains the Memcached Server Connection Pool
		String[] servers = {"127.0.0.1:11111"};
		SockIOPool pool = SockIOPool.getInstance("Test1");
		pool.setServers( servers );
		pool.setFailover( true );
		pool.setInitConn( 10 );
		pool.setMinConn( 5 );
		pool.setMaxConn( 250 );
		pool.setMaintSleep( 30 );
		pool.setNagle( false );
		pool.setSocketTO( 3000 );
		pool.setAliveCheck( true );
		pool.initialize();
		//Get the Memcached Client from SockIOPool named Test1
		MemCachedClient mcc = new MemCachedClient("Test1");
		//add some value in cache
		System.out.println("add status: "+mcc.add("1", "Original"));
		//Get value from cache
		System.out.println("Get from Cache: "+mcc.get("1"));

		System.out.println("add status: "+mcc.add("1", "Modified"));
		System.out.println("Get from Cache: "+mcc.get("1"));

		//use set function to add/update value, use replace to update and not add
		System.out.println("set status: "+mcc.set("1","Modified"));
		System.out.println("Get from Cache after set: "+mcc.get("1"));

		//use delete function to delete the key from cache
		System.out.println("remove status: "+mcc.delete("1"));
		System.out.println("Get from Cache after delete: "+mcc.get("1"));

		//Use getMulti function to retrieve multiple keys values in one function
		// Its helpful in reducing network calls to 1
		mcc.set("2", "2");
		mcc.set("3", "3");
		mcc.set("4", "4");
		mcc.set("5", "5");
		String [] keys = {"1", "2","3","INVALID","5"};
		HashMap<String,Object> hm = (HashMap<String, Object>) mcc.getMulti(keys);

		for(String key : hm.keySet()){
			System.out.println("KEY: "+key+" VALUE: "+hm.get(key));
		}
	}

    
    }

