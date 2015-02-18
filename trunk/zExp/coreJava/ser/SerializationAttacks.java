package coreJava.ser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.InvalidParameterException;

class SerializationAttack implements Serializable {

	int talkTime;
	int talkTImeLimit;
	
	SerializationAttack(int talktime, int timeLimit){
		if(talktime > timeLimit ) throw new InvalidParameterException();
		this.talkTime = talktime;
		this.talkTImeLimit = timeLimit;
	}
	
	public static void main(String[] args) throws Exception {
		SerializationAttack ser = new SerializationAttack(10, 15);
		
		OutputStream oStream = new ByteArrayOutputStream();
		ObjectOutputStream stream = new ObjectOutputStream(oStream);
		stream.writeObject(ser);
		
	}
	
}
