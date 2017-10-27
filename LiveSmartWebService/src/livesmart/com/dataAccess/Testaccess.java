/**
 * 
 */
package livesmart.com.dataAccess;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.EnumSet;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import livesmart.com.dataModel.AlarmDevice;
import livesmart.com.dataModel.CameraDevice;
import livesmart.com.dataModel.Device;
import livesmart.com.dataModel.DeviceType;
import livesmart.com.dataModel.DoorDevice;
import livesmart.com.dataModel.HeatingDevice;
import livesmart.com.dataModel.LightingDevice;
import livesmart.com.dataModel.MusicDevice;
import livesmart.com.dataModel.Room;
import livesmart.com.dataModel.StovenDevice;
import livesmart.com.dataModel.User;
import livesmart.com.dataModel.WindowDevice;

/**
 * @author Dominik Poppek
 *
 */
public class Testaccess {

	public static void main(String[] args) {
	
		//Test DeviceInsert
//		testDeviceInsert();
		 
		//Test GetUser
		long start_time = System.currentTimeMillis();

		testGetUser();

		long end_time = System.currentTimeMillis();

		long difference = end_time-start_time;
	
		System.out.println("Time in ms: " + difference);
		 
		 
		 
	 }
	 
	private static void testGetUser() {
		Session session = HibernateConnector.getInstance().getSession();
		 session.beginTransaction();
		 
		 User u = (User) session.get(User.class, 1);
		 
		 session.getTransaction().commit();
		 session.close();
	}
	
	
	 private static void testDeviceInsert() {
		 ArrayList<Room> rooms = createTestdata();
		 /**
		 /* Testdata already in db, no need to run again (although "just" update)
		 Session session = HibernateConnector.getInstance().getSession();
		 session.beginTransaction();
		 
		 User u = (User) session.get(User.class, 1);
		 u.getRooms().addAll(rooms);
		 u.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		 
		 session.update(u);
		 session.getTransaction().commit();
		 session.close();
		   */
		 
	 }
	 
	 private static ArrayList<Room> createTestdata() {
		 	Room bathroom = new Room("Bathroom", "ic_bathroom_black_18dp");
		 	Room bedroom = new Room("Bedroom", "ic_hotel_black_18dp");
		 	Room dining = new Room("Dining Room", "ic_restaurant_black_18dp");
		 	Room entrance = new Room("Entrance", "ic_vpn_key_black_18dp");
		 	Room garage = new Room("Garage", "ic_drive_eta_black_18dp");
	        Room kitchen = new Room("Kitchen", "ic_local_cafe_black_18dp");
	        Room library = new Room("Library", "ic_school_black_18dp");
	        Room livingroom = new Room("Living Room", "ic_weekend_black_18dp");
	        Room toilette = new Room("Toilette", "ic_wc_black_18dp");
	        
	        /** Devices */
	        //Alarms
	        AlarmDevice a1 = new AlarmDevice();
	        a1.setDeviceMAC("00:80:41:ae:fd:7e");
	        a1.setDeviceName("Door alarm");
	        a1.setDeviceType(DeviceType.ALARM);
	        a1.setRoomName(entrance.getRoomName());
	        
	        AlarmDevice a2 = new AlarmDevice();
	        a2.setDeviceMAC("00:80:41:ae:fd:7e");
	        a2.setDeviceName("Garage alarm");
	        a2.setDeviceType(DeviceType.ALARM);
	        a2.setRoomName(garage.getRoomName());
	        
	        //Cameras
	        CameraDevice c1 = new CameraDevice();
	        c1.setDeviceMAC("00:80:41:ae:fd:7e");
	        c1.setDeviceName("Door camera");
	        c1.setDeviceType(DeviceType.CAMERA);
	        c1.setRoomName(entrance.getRoomName());
	        
	        CameraDevice c2 = new CameraDevice();
	        c2.setDeviceMAC("00:80:41:ae:fd:7e");
	        c2.setDeviceName("Garage camera");
	        c2.setDeviceType(DeviceType.CAMERA);
	        c2.setRoomName(entrance.getRoomName());
	        
	        //Doors
	        DoorDevice d1 = new DoorDevice();
	        d1.setDeviceMAC("00:80:41:ae:fd:7e");
	        d1.setDeviceName("Entrance door lock");
	        d1.setDeviceType(DeviceType.DOOR);
	        d1.setRoomName(entrance.getRoomName());
	        
	        DoorDevice d2 = new DoorDevice();
	        d2.setDeviceMAC("00:80:41:ae:fd:7e");
	        d2.setDeviceName("Garage door lock");
	        d2.setDeviceType(DeviceType.DOOR);
	        d2.setRoomName(garage.getRoomName());
	        
	        //Heatings
	        HeatingDevice h1 = new HeatingDevice();
	        h1.setDeviceMAC("00:80:41:ae:fd:7e");
	        h1.setDeviceName("Bathroom Heating");
	        h1.setDeviceType(DeviceType.HEATING);
	        h1.setRoomName(bathroom.getRoomName());
	        
	        HeatingDevice h2 = new HeatingDevice();
	        h2.setDeviceMAC("00:80:41:ae:fd:7e");
	        h2.setDeviceName("Bedroom Heating");
	        h2.setDeviceType(DeviceType.HEATING);
	        h2.setRoomName(bedroom.getRoomName());
	        
	        HeatingDevice h3 = new HeatingDevice();
	        h3.setDeviceMAC("00:80:41:ae:fd:7e");
	        h3.setDeviceName("Dining room Heating");
	        h3.setDeviceType(DeviceType.HEATING);
	        h3.setRoomName(dining.getRoomName());

	        HeatingDevice h4 = new HeatingDevice();
	        h4.setDeviceMAC("00:80:41:ae:fd:7e");
	        h4.setDeviceName("Kitchen Heating");
	        h4.setDeviceType(DeviceType.HEATING);
	        h4.setRoomName(kitchen.getRoomName());
	        
	        HeatingDevice h5 = new HeatingDevice();
	        h5.setDeviceMAC("00:80:41:ae:fd:7e");
	        h5.setDeviceName("Library Heating");
	        h5.setDeviceType(DeviceType.HEATING);
	        h5.setRoomName(library.getRoomName());
	        
	        HeatingDevice h6 = new HeatingDevice();
	        h6.setDeviceMAC("00:80:41:ae:fd:7e");
	        h6.setDeviceName("Living room Heating");
	        h6.setDeviceType(DeviceType.HEATING);
	        h6.setRoomName(livingroom.getRoomName());
	        
	        HeatingDevice h7 = new HeatingDevice();
	        h7.setDeviceMAC("00:80:41:ae:fd:7e");
	        h7.setDeviceName("Toilette Heating");
	        h7.setDeviceType(DeviceType.HEATING);
	        h7.setRoomName(toilette.getRoomName());
	        
	        //Lightnings
	        LightingDevice l1 = new LightingDevice();
	        l1.setDeviceMAC("00:80:41:ae:fd:7e");
	        l1.setDeviceName("Bathroom Lighting");
	        l1.setDeviceType(DeviceType.LIGHTING);
	        l1.setRoomName(bathroom.getRoomName());
	        
	        LightingDevice l2 = new LightingDevice();
	        l2.setDeviceMAC("00:80:41:ae:fd:7e");
	        l2.setDeviceName("Bedroom Lighting");
	        l2.setDeviceType(DeviceType.LIGHTING);
	        l2.setRoomName(bedroom.getRoomName());
	        
	        LightingDevice l3 = new LightingDevice();
	        l3.setDeviceMAC("00:80:41:ae:fd:7e");
	        l3.setDeviceName("Dining room Lighting");
	        l3.setDeviceType(DeviceType.LIGHTING);
	        l3.setRoomName(dining.getRoomName());
	        
	        LightingDevice l4 = new LightingDevice();
	        l4.setDeviceMAC("00:80:41:ae:fd:7e");
	        l4.setDeviceName("Entrance Lighting");
	        l4.setDeviceType(DeviceType.LIGHTING);
	        l4.setRoomName(entrance.getRoomName());
	        
	        LightingDevice l5 = new LightingDevice();
	        l5.setDeviceMAC("00:80:41:ae:fd:7e");
	        l5.setDeviceName("Garage Lighting");
	        l5.setDeviceType(DeviceType.LIGHTING);
	        l5.setRoomName(garage.getRoomName());
	        
	        LightingDevice l6 = new LightingDevice();
	        l6.setDeviceMAC("00:80:41:ae:fd:7e");
	        l6.setDeviceName("Kitchen Lighting");
	        l6.setDeviceType(DeviceType.LIGHTING);
	        l6.setRoomName(kitchen.getRoomName());

	        LightingDevice l7 = new LightingDevice();
	        l7.setDeviceMAC("00:80:41:ae:fd:7e");
	        l7.setDeviceName("Library Lighting");
	        l7.setDeviceType(DeviceType.LIGHTING);
	        l7.setRoomName(library.getRoomName());
	        
	        LightingDevice l8 = new LightingDevice();
	        l8.setDeviceMAC("00:80:41:ae:fd:7e");
	        l8.setDeviceName("Living room Lighting");
	        l8.setDeviceType(DeviceType.LIGHTING);
	        l8.setRoomName(livingroom.getRoomName());
	        
	        LightingDevice l9 = new LightingDevice();
	        l9.setDeviceMAC("00:80:41:ae:fd:7e");
	        l9.setDeviceName("Toilette Lighting");
	        l9.setDeviceType(DeviceType.LIGHTING);
	        l9.setRoomName(toilette.getRoomName());
	        
	        //Musics
	        MusicDevice m1 = new MusicDevice();
	        m1.setDeviceMAC("00:80:41:ae:fd:7e");
	        m1.setDeviceName("Bathroom Music");
	        m1.setDeviceType(DeviceType.MUSIC);
	        m1.setRoomName(bathroom.getRoomName());
	        
	        MusicDevice m2 = new MusicDevice();
	        m2.setDeviceMAC("00:80:41:ae:fd:7e");
	        m2.setDeviceName("Bedroom Music");
	        m2.setDeviceType(DeviceType.MUSIC);
	        m2.setRoomName(bedroom.getRoomName());
	        
	        MusicDevice m3 = new MusicDevice();
	        m3.setDeviceMAC("00:80:41:ae:fd:7e");
	        m3.setDeviceName("Library Music");
	        m3.setDeviceType(DeviceType.MUSIC);
	        m3.setRoomName(library.getRoomName());
	        
	        MusicDevice m4 = new MusicDevice();
	        m4.setDeviceMAC("00:80:41:ae:fd:7e");
	        m4.setDeviceName("Living room Music");
	        m4.setDeviceType(DeviceType.MUSIC);
	        m4.setRoomName(livingroom.getRoomName());

	        //Stovens
	        StovenDevice s1 = new StovenDevice();
	        s1.setDeviceMAC("00:80:41:ae:fd:7e");
	        s1.setDeviceName("Kitchen Stoven");
	        s1.setDeviceType(DeviceType.STOVEN);
	        s1.setRoomName(kitchen.getRoomName());

	        //Windows
	        WindowDevice w1 = new WindowDevice();
	        w1.setDeviceMAC("00:80:41:ae:fd:7e");
	        w1.setDeviceName("Bathroom Window");
	        w1.setDeviceType(DeviceType.WINDOW);
	        w1.setRoomName(bathroom.getRoomName());
	        
	        WindowDevice w2 = new WindowDevice();
	        w2.setDeviceMAC("00:80:41:ae:fd:7e");
	        w2.setDeviceName("Bedroom Window");
	        w2.setDeviceType(DeviceType.WINDOW);
	        w2.setRoomName(bedroom.getRoomName());
	        
	        WindowDevice w3 = new WindowDevice();
	        w3.setDeviceMAC("00:80:41:ae:fd:7e");
	        w3.setDeviceName("Dining room Window");
	        w3.setDeviceType(DeviceType.WINDOW);
	        w3.setRoomName(dining.getRoomName());
	        
	        WindowDevice w4 = new WindowDevice();
	        w4.setDeviceMAC("00:80:41:ae:fd:7e");
	        w4.setDeviceName("Kitchen Window");
	        w4.setDeviceType(DeviceType.WINDOW);
	        w4.setRoomName(kitchen.getRoomName());

	        WindowDevice w5 = new WindowDevice();
	        w5.setDeviceMAC("00:80:41:ae:fd:7e");
	        w5.setDeviceName("Library Window");
	        w5.setDeviceType(DeviceType.WINDOW);
	        w5.setRoomName(library.getRoomName());
	        
	        WindowDevice w6 = new WindowDevice();
	        w6.setDeviceMAC("00:80:41:ae:fd:7e");
	        w6.setDeviceName("Living room Window");
	        w6.setDeviceType(DeviceType.WINDOW);
	        w6.setRoomName(livingroom.getRoomName());
	        
	        WindowDevice w7 = new WindowDevice();
	        w7.setDeviceMAC("00:80:41:ae:fd:7e");
	        w7.setDeviceName("Toilette Window");
	        w7.setDeviceType(DeviceType.WINDOW);
	        w7.setRoomName(toilette.getRoomName());
	        
	        
	        
	        /** Bathroom add devices */
	        ArrayList<Device> bathroomDevices = new ArrayList<Device>();
	        bathroomDevices.add(h1);
	        bathroomDevices.add(l1);
	        bathroomDevices.add(m1);
	        bathroomDevices.add(w1);
	        bathroom.setDeviceList(bathroomDevices);

	        /** Bedroom add devices */
	        ArrayList<Device> bedroomDevices = new ArrayList<Device>();
	        bedroomDevices.add(h2);
	        bedroomDevices.add(l2);
	        bedroomDevices.add(m2);
	        bedroomDevices.add(w2);
	        bedroom.setDeviceList(bedroomDevices);
	        
	        /** Dining add devices */
	        ArrayList<Device> diningDevices = new ArrayList<Device>();
	        diningDevices.add(h3);
	        diningDevices.add(l3);
	        diningDevices.add(w3);
	        dining.setDeviceList(diningDevices);
	        
	        /** Entrance add devices */
	        ArrayList<Device> entranceDevices = new ArrayList<Device>();
	        entranceDevices.add(a1);
	        entranceDevices.add(c1);
	        entranceDevices.add(d1);
	        entranceDevices.add(l4);
	        entrance.setDeviceList(entranceDevices);
	        
	        /** Garage add Devices*/
	        ArrayList<Device> garageDevices = new ArrayList<Device>();
	        garageDevices.add(a2);
	        garageDevices.add(c2);
	        garageDevices.add(d2);
	        garageDevices.add(l5);
	        garage.setDeviceList(garageDevices);
	        
	        
	        /** Kitchen add Devices*/
	        ArrayList<Device> kitchenDevices = new ArrayList<Device>();
	        kitchenDevices.add(h4);
	        kitchenDevices.add(l6);
	        kitchenDevices.add(s1);
	        kitchenDevices.add(w4);
	        kitchen.setDeviceList(kitchenDevices);
	        
	        /** Library add devices */
	        ArrayList<Device> libraryDevices = new ArrayList<Device>();
	        libraryDevices.add(h5);
	        libraryDevices.add(l7);
	        libraryDevices.add(m3);
	        libraryDevices.add(w5);
	        library.setDeviceList(libraryDevices);
	        
	        /** Living room add devices */
	        ArrayList<Device> livingroomDevices = new ArrayList<Device>();
	        livingroomDevices.add(h6);
	        livingroomDevices.add(l8);
	        livingroomDevices.add(m4);
	        livingroomDevices.add(w6);
	        livingroom.setDeviceList(livingroomDevices);
	        
	        /** Toilette add devices */
	        ArrayList<Device> toiletteDevices = new ArrayList<Device>();
	        toiletteDevices.add(h7);
	        toiletteDevices.add(l9);
	        toiletteDevices.add(w7);
	        toilette.setDeviceList(toiletteDevices);

	        
	        
	        /** Create rooms list */
	        ArrayList<Room> rooms = new ArrayList<Room>();

	        rooms.add(bathroom);
	        rooms.add(bedroom);
	        rooms.add(dining);
	        rooms.add(entrance);
	        rooms.add(garage);
	        rooms.add(kitchen);
	        rooms.add(library);
	        rooms.add(livingroom);
	        rooms.add(toilette);
	        
	        return rooms;
	 }
	 
	 
	 
	 
	 /**
	  * Creating db-schema as .ddl
	  */
	 private static void createSchemaWithHibernate5() {
		    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() //
		            .configure() //
		            .build();
		    Metadata metadata = new MetadataSources(serviceRegistry) //
		            .buildMetadata();
		 
		    new SchemaExport() //
		            .setOutputFile("db-schema.hibernate5.ddl") //
		            .create(EnumSet.of(TargetType.SCRIPT), metadata);
		 
		    metadata.buildSessionFactory().close();
		}
}
