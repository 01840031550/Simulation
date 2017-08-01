/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation.of.queueing.systems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rashe_000
 */
public class SimulationOfQueueingSystems {
    
    Scanner sc = new Scanner(System.in);

    private int arrival_gun = 0;
    private int service_gun = 0;

    private int first = 0;
    private float cpr = 0;
    private int ending = 0;
    private float probability = 0.0f;
    private int nr = 0;
    private float service[];

    //service time
    private int j = 0;
    private float cps = 0;
    private int start = 0;
    private int ends = 0;
    private int ns = 0;

    //arrival random digit and service random digit er jonne
    private int nard = 0;
    private int nsrd = 0;
    private int[] ard;
    private int[] asd;

    private int stating_time_service = 0;
    private int ending_time_service = 0;
    private int watting_time_service = 0;
    private int customer_wati_in_sevice = 0;
    private int idal_time_in_server = 0;
    private int ar = 0;
    private int st = 0;

    private List<Integer> arrivalTimeArray = new ArrayList<Integer>();
    private List<Integer> serviceTimeArray = new ArrayList<Integer>();
    private List<Integer> stating_time_service_list = new ArrayList<Integer>();
    private List<Integer> ending_time_service_list = new ArrayList<Integer>();
    private List<Integer> customer_wati_in_sevice_list = new ArrayList<Integer>();
    private List<Integer> watting_time_service_list = new ArrayList<Integer>();
    private List<Integer> idal_time_in_server_list = new ArrayList<Integer>();

    public static void main(String[] args) {

        SimulationOfQueueingSystems np = new SimulationOfQueueingSystems();
        np.arrival();
        np.service();
        np.ard();
        np.asd();
        np.finalTable();
        np.operation();
        np.output();
        np.caluculation();

    }

    private void arrival() {
        String afterPoint = null;
        System.out.print("how much in arrival element : ");

        this.nr = sc.nextInt();
        String cp = null;

        this.probability = (float) 1 / this.nr;

        //Math.round(this.probability);
        try {
            String pro = String.valueOf(this.probability);
            afterPoint = pro.split("\\.")[1];

            if (afterPoint.length() == 4) {
                this.arrival_gun = 10000;
            } else if (afterPoint.length() == 3) {
                this.arrival_gun = 1000;
            } else if (afterPoint.length() == 2) {
                this.arrival_gun = 100;
            } else if (afterPoint.length() == 1) {
                this.arrival_gun = 10;
            } else {
                this.arrival_gun = 1000;
            }

            for (int i = 1; i <= this.nr; i++) {
                int initil = ending + 1;
                this.cpr = this.cpr + this.probability;
                float end = this.cpr * this.arrival_gun;
                this.ending = (int) end;
                String file = String.valueOf(this.cps);
                String exten = file.split("\\.")[1];

                if (exten.length() == 1) {
                    cp = String.format("%.01f", this.cpr);
                } else if (exten.length() == 2) {
                    cp = String.format("%.02f", this.cpr);
                } else {
                    cp = String.format("%.03f", this.cpr);
                }

                System.out.println(i + " \t " + this.probability + " \t " + cp + " \t " + initil + "\t-\t " + ending);

            }
        } catch (Exception e) {
            System.out.println("0");
        }

    }

    private void service() {
        System.out.println(" \n");
        System.out.println("enter Service time element : ");
        this.ns = sc.nextInt();
        this.service = new float[this.ns];
        System.out.println("enter Service time probability : ");

        for (int i = 0; i < this.ns; i++) {
            this.service[i] = sc.nextFloat();

        }
        System.out.println("enter Service time  : ");
        for (float i : this.service) {
            String cp = null;
            this.start = ends + 1;
            this.cps = this.cps + i;
            this.j = this.j + 1;

            String filename = String.valueOf(this.cps);
            String extensionRemoved = filename.split("\\.")[1];
            if (extensionRemoved.length() == 4) {
                this.service_gun = 10000;
                float end = this.cps * service_gun;
                this.ends = (int) end;
            } else if (extensionRemoved.length() == 3) {
                this.service_gun = 1000;
                float end = this.cps * service_gun;
                this.ends = (int) end;
            } else if (extensionRemoved.length() == 2) {
                this.service_gun = 100;
                float end = this.cps * service_gun;
                this.ends = (int) end;
            } else if (extensionRemoved.length() == 1) {
                this.service_gun = 10;
                float end = this.cps * service_gun;
                this.ends = (int) end;
            } else {
                this.service_gun = 1000;
                float end = this.cps * service_gun;
                this.ends = (int) end;
            }
            String file = String.valueOf(this.cps);
            String exten = filename.split("\\.")[1];

            if (exten.length() == 1) {
                cp = String.format("%.01f", this.cps);
            } else if (exten.length() == 2) {
                cp = String.format("%.02f", this.cps);
            } else {
                cp = String.format("%.03f", this.cps);
            }

            System.out.println(j + "\t" + i + "\t" + cp + "\t" + this.start + "\t-\t" + this.ends);
        }

    }

    private void ard() {
        System.out.println("enter Arrival RD time element : ");
        this.nard = sc.nextInt();
        this.ard = new int[this.nard];
        System.out.println("enter Arrival RD time : ");
        for (int i = 0; i < this.nard; i++) {
            ard[i] = sc.nextInt();
        }
    }

    private void asd() {
        System.out.println("enter Service RD time element : ");
        this.nsrd = sc.nextInt();
        this.asd = new int[this.nsrd];
        System.out.println("enter Service RD time : ");
        for (int i = 0; i < this.nsrd; i++) {
            this.asd[i] = sc.nextInt();
        }
    }

    private void finalTable() {
        System.out.println("Arrival simulation : ");
        for (int i : ard) {
            int tba = timeBetweenArrival(i);
            this.ar = this.ar + tba;
            this.arrivalTimeArray.add(this.ar);
            System.out.println(i + "\t" + tba + "\t" + this.ar);
        }

        System.out.println("Service simulation : ");
        for (int i : asd) {
            st = serviceTime(i);
            this.serviceTimeArray.add(st);
            System.out.println(i + "\t" + st);
        }
        System.out.println("");
    }

    private void operation() {
        for (int i = 0; i < arrivalTimeArray.size(); i++) {
            for (int j = 0; j < serviceTimeArray.size(); j++) {
                if (i == j) {
                    ending_time_service = arrivalTimeArray.get(i) + serviceTimeArray.get(j);
                    ending_time_service_list.add(ending_time_service);
                }
            }
        }

        for (int i = 0; i < ending_time_service_list.size(); i++) {
            for (int j = 0; j < arrivalTimeArray.size(); j++) {
                if (i == 0 && j == 0) {
                    stating_time_service_list.add(0);
                }
                if ((i < j) && (i != j)) {
                    if (ending_time_service_list.get(i) < arrivalTimeArray.get(j)) {
                        stating_time_service_list.add(arrivalTimeArray.get(j));
                    } else {
                        stating_time_service_list.add(ending_time_service_list.get(i));
                    }

                    j = arrivalTimeArray.size();
                }
            }
        }

        for (int i = 0; i < arrivalTimeArray.size(); i++) {
            for (int j = 0; j < ending_time_service_list.size(); j++) {
                if (i == j) {
                    customer_wati_in_sevice = ending_time_service_list.get(j) - arrivalTimeArray.get(i);
                    customer_wati_in_sevice_list.add(customer_wati_in_sevice);
                }
            }
        }

        for (int i = 0; i < customer_wati_in_sevice_list.size(); i++) {
            for (int j = 0; j < serviceTimeArray.size(); j++) {
                if (i == j) {
                    watting_time_service = customer_wati_in_sevice_list.get(i) - serviceTimeArray.get(j);
                    watting_time_service_list.add(watting_time_service);
                }
            }
        }

        for (int i = 0; i < ending_time_service_list.size(); i++) {
            for (int j = 0; j < stating_time_service_list.size(); j++) {
                if (i == 0 && j == 0) {
                    idal_time_in_server_list.add(0);
                }
                if (i < j) {
                    if (ending_time_service_list.get(i) < stating_time_service_list.get(j)) {
                        int idal_time = stating_time_service_list.get(j) - ending_time_service_list.get(i);
                        idal_time_in_server_list.add(idal_time);
                    } else {
                        int idal_time = stating_time_service_list.get(j) - ending_time_service_list.get(i);
                        idal_time_in_server_list.add(idal_time);
                    }

                    j = stating_time_service_list.size();
                }
            }
        }
    }

    private void output() {
        Integer[] arrivalTime = this.arrivalTimeArray.toArray(new Integer[this.arrivalTimeArray.size()]);
        Integer[] serviceTime = this.serviceTimeArray.toArray(new Integer[this.serviceTimeArray.size()]);
        Integer[] stating_time_service_array = this.stating_time_service_list.toArray(new Integer[this.stating_time_service_list.size()]);
        Integer[] ending_time_service_array = this.ending_time_service_list.toArray(new Integer[this.ending_time_service_list.size()]);
        Integer[] customer_wati_in_sevice_array = this.customer_wati_in_sevice_list.toArray(new Integer[this.customer_wati_in_sevice_list.size()]);
        Integer[] watting_time_service_array = this.watting_time_service_list.toArray(new Integer[this.watting_time_service_list.size()]);
        Integer[] idal_time_in_server_array = this.idal_time_in_server_list.toArray(new Integer[this.idal_time_in_server_list.size()]);

        Integer[][] output = {arrivalTime, serviceTime, stating_time_service_array, watting_time_service_array,
            ending_time_service_array, customer_wati_in_sevice_array, idal_time_in_server_array};

        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.println("Arrival Time : \n");
                }
                if (i == 1 && j == 0) {
                    System.out.println("Service Time : \n");
                }
                if (i == 2 && j == 0) {
                    System.out.println("Stating Time in the service : \n");
                }
                if (i == 3 && j == 0) {
                    System.out.println("Watting Time in the service : \n");
                }
                if (i == 4 && j == 0) {
                    System.out.println("Ending Time in the service  : \n");
                }
                if (i == 5 && j == 0) {
                    System.out.println("Customer watting Time in the service : \n");
                }
                if (i == 6 && j == 0) {
                    System.out.println("Idal Time in the service : \n");
                }

                System.out.print("\t" + output[i][j]);
            }
            System.out.println("\n");
        }
    }

    int stating_tva = 0;

    private int timeBetweenArrival(int x) {
        float tcpr = 0;
        int tending = 0;
        float end = 0;
        int initil = 0;
        for (int i = 1; i <= this.nr; i++) {
            if (this.stating_tva == 0) {
                this.stating_tva = 1;
                return 0;
            }
            initil = tending + 1;
            tcpr = tcpr + this.probability;
            end = tcpr * this.arrival_gun;
            tending = (int) end;
            if (x >= initil && x <= tending) {

                return i;
            }
        }
        return this.nr;
    }

    private int serviceTime(int y) {
        int start = 0;
        float cps = 0.0f;
        int ends = 0;
        float end = 0;
        int count = 0;
        try {
            for (int i = 0; i <= this.service.length; i++) {
                start = ends + 1;
                int j = i + 1;
                cps = cps + this.service[i];
                end = cps * this.service_gun;
                ends = (int) end;
                if (y >= start && y <= ends) {
                    return j;

                }
            }
        } catch (Exception e) {
            count++;
            if (count < 1) {
                System.out.println("Service time not define , so return 0");
            }
        }
        return 0;
    }

    private void caluculation() {

        int a = 0;
        float watting_time_server = 0;
        for (Integer i : watting_time_service_list) {
            watting_time_server = watting_time_server + (Float.parseFloat(i.toString()));
            a++;
        }
        System.out.println("Average waiting time : " + (watting_time_server / a));

        int b = 0;
        float arrival = 0;
        for (Integer i : arrivalTimeArray) {
            arrival = arrival + (Float.parseFloat(i.toString()));
            b++;
        }
        float atba = (arrival / (b - 1));
        System.out.println("Average time beteween arrivals : " + atba);

        int c = 0;
        float max = Float.parseFloat(customer_wati_in_sevice_list.get(0).toString());
        for (int i = 0; i < customer_wati_in_sevice_list.size(); i++) {
            c++;
            if (customer_wati_in_sevice_list.get(i) < max) {
                max = max;
            } else {
                max = customer_wati_in_sevice_list.get(i);
            }

        }
        float pcwt = (max / c);
        System.out.println("Probability of cutomer watting time :" + pcwt);

        float total_idle_time_of_server = 0;
        float total_end_time_of_server = 0;
        for (Integer i : idal_time_in_server_list) {
            total_idle_time_of_server = total_idle_time_of_server + (Float.parseFloat(i.toString()));
        }

        for (Integer i : ending_time_service_list) {
            total_end_time_of_server = Float.parseFloat(i.toString());
        }
        float pbs = (1 - (total_idle_time_of_server / total_end_time_of_server));
        System.out.println("Probability of busy server : " + pbs);

        int d = 0;
        float total_customer_waitting_time = 0;

        for (Integer i : customer_wati_in_sevice_list) {
            d++;
            total_customer_waitting_time = total_customer_waitting_time + (Float.parseFloat(i.toString()));
        }
        float astc = (total_customer_waitting_time / d);
        System.out.println("Average spending time of customer : " + astc);

    }

}



