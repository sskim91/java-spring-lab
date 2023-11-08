package indonesia;

import indonesia.xml.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.util.Arrays;

/**
 * @author sskim
 */
public class XmlMain {
    public static void main(String[] args) throws Exception {


        BimsXML bimsXML = new BimsXML();
        StationNode stationNode = new StationNode();
        stationNode.setCode("123");
        stationNode.setName("name");
        stationNode.setLabel("label");
        Vertex vertex = new Vertex();
        vertex.setCx("1");
        vertex.setCy("2");
        stationNode.setVertex(Arrays.asList(vertex));
        bimsXML.addNodes(stationNode);

        StationNode stationNode2 = new StationNode();
        stationNode2.setCode("123");
        stationNode2.setName("name");
        stationNode2.setLabel("label");
        Vertex vertex2 = new Vertex();
        vertex2.setCx("1");
        vertex2.setCy("2");
        stationNode2.setVertex(Arrays.asList(vertex2));
        bimsXML.addNodes(stationNode2);

        Route route = new Route();
        route.setCode("8");
        route.setName("8번노선");
        RouteNode routeNode = new RouteNode();
        routeNode.setCode("1000000005");
        routeNode.setName("Arah ke Pasar Ciawi");
        routeNode.setLongitude("70992");
        routeNode.setDestination("Pasar Ciawi");

        RouteStationNode routeStationNode = new RouteStationNode();
        routeStationNode.setType("1");
        routeStationNode.setCode("200000011");
        routeStationNode.setPosition("0");
        routeStationNode.setAttribute("65");

        Vertex routeVertex = new Vertex();
        routeVertex.setCy("123");
        routeVertex.setCx("333");
        routeNode.addVertex(routeVertex);

        Subline subline = new Subline();
        subline.setCode("8");
        subline.setLabel("PILOT-8");

        SublineRoute sublineRoute = new SublineRoute();
        sublineRoute.setCode("1000000005");
        sublineRoute.setOrder("1");

        subline.setRoutes(Arrays.asList(sublineRoute));


        routeNode.addNode(routeStationNode);
        route.addRoute(routeNode);
        route.addSublines(subline);


        //최종
        bimsXML.addLines(route);

        JAXBContext jaxbContext = JAXBContext.newInstance(BimsXML.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(bimsXML, System.out);


    }
}
