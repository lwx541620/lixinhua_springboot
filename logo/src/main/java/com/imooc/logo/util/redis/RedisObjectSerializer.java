package com.imooc.logo.util.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisObjectSerializer implements RedisSerializer<Object> {
   private Converter<Object,byte[]> serializingConverter=new SerializingConverter();
   private Converter<byte[],Object> deserializingConverter=new DeserializingConverter();
   private static final byte[] EMPTY_BYTE_ARRAY=new byte[0];
	@Override
	public byte[] serialize(Object obj) throws SerializationException {
		// TODO Auto-generated method stub
		if(obj==null) 
		{
			return EMPTY_BYTE_ARRAY;
		}
		return serializingConverter.convert(obj);
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		// TODO Auto-generated method stub
		if(bytes==null || bytes.length==0) {
			return null;
		}
		return deserializingConverter.convert(bytes);
	}

}
