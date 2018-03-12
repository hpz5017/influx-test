package app.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class HeaderLookup implements CommandLineRunner {

    @Autowired
    private ConfigurableApplicationContext context;

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public static void main(String[] args) {
        SpringApplication.run(HeaderLookup.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String userIn;
        Scanner sc = new Scanner(System.in);
        String tip = "\n\nInput a header name (q to exit): ";

        System.out.println(tip);

        while (!(userIn = sc.nextLine()).toLowerCase().equals("q")) {

            String[] headerName = userIn.toUpperCase().split("_");

            List<Mapping> c = jdbcTemplate.query(
                    "SELECT * FROM `feature_mapping` WHERE SID = ?", new Object[]{headerName[0]},
                    (rs, rowNum) -> new Mapping(
                            rs.getLong("id"), rs.getString("type"), rs.getString("electrode"),
                            rs.getDouble("freq_low"), rs.getDouble("freq_high"),
                            rs.getString("brain_location"), rs.getString("notes"),
                            rs.getString("SID"), rs.getInt("SID_Count"))
            );

            if (c.size() == 0) {
                System.out.println("No such SID!");
            } else {
                Mapping m = c.get(0);
                System.out.print(String.format("'%s' is type: %s. ", headerName[0], m.getType()));
                int subId = Integer.parseInt(headerName[1]);
                if (!m.getNotes().isEmpty()) {
                    System.out.print(String.format("It has a note: %s. ", m.getNotes()));
                }
                if (m.getCount() < subId) {
                    System.out.println("However the sub index does not exist!");
                }
            }

            System.out.println(tip);
        }

        SpringApplication.exit(context);
    }

    public class Mapping {
        private long id;
        private String electrode, brain_location, sid, type, notes;
        private int count;
        private double freq_low, freq_high;

        public Mapping(long id, String t, String electrode,
                       double freq_low, double freq_high, String brain_location, String notes,
                       String sid, int sid_count) {
            this.id = id;
            this.type = t;
            this.electrode = electrode;
            this.freq_high = freq_high;
            this.freq_low = freq_low;
            this.brain_location = brain_location;
            this.sid = sid;
            this.count = sid_count;
            this.notes = notes;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getElectrode() {
            return electrode;
        }

        public void setElectrode(String electrode) {
            this.electrode = electrode;
        }

        public String getBrain_location() {
            return brain_location;
        }

        public void setBrain_location(String brain_location) {
            this.brain_location = brain_location;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getFreq_low() {
            return freq_low;
        }

        public void setFreq_low(double freq_low) {
            this.freq_low = freq_low;
        }

        public double getFreq_high() {
            return freq_high;
        }

        public void setFreq_high(double freq_high) {
            this.freq_high = freq_high;
        }
    }

}
