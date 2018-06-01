package pruebaFirebase;

import java.io.FileInputStream;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Control extends Thread {

	PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	SerialPortEventListener listener;

	String mensajeArduino;
	String[] datosArduino;

	int valMic, valMov;

	public Control() {
		listener = new SerialPortEventListener() {

			@Override
			public void serialEvent(SerialPortEvent arg0) {
				try {
					if (ino.isMessageAvailable()) {
						mensajeArduino = ino.printMessage();
						recepcionArduino();
						// System.out.println(ino.printMessage());
					}
				} catch (SerialPortException | ArduinoException e) {
					e.printStackTrace();
				}

			}
		};

		try {
			ino.arduinoRXTX("COM8", 9600, listener);
		} catch (ArduinoException e1) {
			e1.printStackTrace();
		}

		try {
			FileInputStream serviceAccount = new FileInputStream("freeControl.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://free-b198f.firebaseio.com").build();
			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
		}

		// As an admin, the app has access to read and write all data, regardless of
		// Security Rules

	}

	public void recepcionArduino() {
		if (mensajeArduino != null) {
			datosArduino = mensajeArduino.split("//");

			valMic = Integer.valueOf(datosArduino[3]);
			valMov = Integer.valueOf(datosArduino[2]);
		}

		if (datosArduino != null) {
			DatabaseReference ref = FirebaseDatabase.getInstance().getReference("SALAS");
			ref.child("305C").setValue(new Sala(datosArduino[0],datosArduino[1],datosArduino[2],
					datosArduino[3],datosArduino[4], "305C"));
			
			DatabaseReference refDB = FirebaseDatabase.getInstance().getReference("USERS");

			evaluacionDatos(refDB);

			ref.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot dataSnapshot) {
					Object document = dataSnapshot.getValue();
					System.out.println(document);
				}

				@Override
				public void onCancelled(DatabaseError error) {
				}
			});
		}
	}

	private void evaluacionDatos(DatabaseReference refDB) {
		String r = "0";
		String m = "2";
		String u = "3";
		
		if (valMic >= 35) {
			envioArduino(r.trim());
		}

		if (valMov == 0) {
			envioArduino(m.trim());
		}
		
		refDB.addValueEventListener(new ValueEventListener() {
			
			@Override
			public void onDataChange(DataSnapshot arg0) {
			}
			
			@Override
			public void onCancelled(DatabaseError arg0) {
	
			}
		});
	}

	public void envioArduino(String mensaje) {
		try {
			ino.sendData(mensaje);
			System.out.println(mensaje);
		} catch (ArduinoException | SerialPortException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
