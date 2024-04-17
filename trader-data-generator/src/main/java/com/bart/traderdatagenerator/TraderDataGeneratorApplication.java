package com.bart.traderdatagenerator;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TraderDataGeneratorApplication {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers","kafka-1:9092");
		properties.setProperty("key.serializer",StringSerializer.class.getName());

		properties.setProperty("value.serializer",StringSerializer.class.getName());

		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
		
		ProducerRecord<String, String> record = new ProducerRecord<String,String>("first_topic", "Second message in docker container!");

		producer.send(record);

		producer.flush();

		producer.close();
	}

}
