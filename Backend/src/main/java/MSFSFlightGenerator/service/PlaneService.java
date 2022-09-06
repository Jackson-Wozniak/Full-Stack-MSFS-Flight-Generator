package MSFSFlightGenerator.service;

import MSFSFlightGenerator.model.entity.Plane;
import MSFSFlightGenerator.repository.PlaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaneService {

    @Autowired
    private final PlaneRepository planeRepository;

    //this method will be used when I create a combo box on frontend including all plane names
//    public Plane findPlaneById(String name){
//        return planeRepository.findById(name)
//                .orElseThrow(() -> new CustomException("cannot find plane"));
//    }

    public List<Plane> findAllPlanes(){
        return planeRepository.findAll();
    }

    public void saveNewPlane(Plane plane){
        planeRepository.save(plane);
    }

    public Plane findRandomPlane(){
        return planeRepository.getRandomPlane();
    }

    /*
    Checks to see if plane type is any, at which point it returns a random plane
    Otherwise it returns the plane that was requested
     */
    public Plane findRandomPlaneByType(String type){
        if(type.equals("any")){
            return planeRepository.getRandomPlane();
        }
        return planeRepository.getRandomPlaneByType(type);
    }
}