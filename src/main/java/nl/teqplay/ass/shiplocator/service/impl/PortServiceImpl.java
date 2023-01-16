package nl.teqplay.ass.shiplocator.service.impl;

import nl.teqplay.ass.shiplocator.config.PortData;
import nl.teqplay.ass.shiplocator.model.PortEvent;
import nl.teqplay.ass.shiplocator.repository.PortEventRepository;
import nl.teqplay.ass.shiplocator.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Service
public class PortServiceImpl implements PortService {

    @Autowired
    private final PortEventRepository portEventRepository;
    @Autowired
    private final PortData portData;

    @Autowired
    public PortServiceImpl(PortEventRepository portEventRepository,PortData portData){
        this.portEventRepository=portEventRepository;
        this.portData=portData;
    }

    @Override
    public PortEvent savePortEventInfo(PortEvent portEvent) {
        return portEventRepository.save(portEvent);
    }

    public List<PortEvent> getAllPortEvents() {
        return portEventRepository.findAll();
    }
    public List<PortEvent> getAllPortEvents(int pageNum) {
        return portEventRepository.findAll(
                PageRequest.of(pageNum,10,Sort.by("eventTime")))
                .stream().toList();
    }
}
