package com.scholarbowlquestionproj.scholarbowlquestions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/packets")
public class PacketController {
    @Autowired
    private PacketRepository packetRepository;

    // Create Packet
    @PostMapping
    public Packet createPacket(@RequestBody Packet packet){
        return this.packetRepository.save(packet);
    }

    // Get Packets
    @GetMapping
    public List<Packet> getPacket(){
        return this.packetRepository.findAll();
    }

    // Get Packet by Id
    @GetMapping("/{id}")
    public Packet getPacketById(@PathVariable(value = "id") long packetId){
        return this.packetRepository.findById(packetId)
        .orElseThrow(() -> new ResourceNotFoundException("Packet Not Found With ID:" + packetId));
    }

    // Put Packet by ID
    @PutMapping("/update/{id}")
    public Packet putPacketById(@RequestBody Packet packet, @PathVariable(value = "id") long packetId){
        Packet exisiting = this.packetRepository.findById(packetId)
        .orElseThrow(() -> new ResourceNotFoundException("Packet Not Found With ID:" + packetId));

        exisiting.setPacketNumber(packet.getPacketNumber());
        exisiting.setYear(packet.getYear());
        exisiting.setTitle(packet.getTitle());
        return this.packetRepository.save(exisiting);
    }

    // Delete Question by ID
    @DeleteMapping("{id}")
    public ResponseEntity<Packet> deletePacket(@PathVariable ("id") long PacketId){
        Packet exisiting = this.packetRepository.findById(PacketId)
        .orElseThrow(() -> new ResourceNotFoundException("Packet Not Found With ID:" + PacketId));

        this.packetRepository.delete(exisiting);

        return ResponseEntity.ok().build();
    }
    
}
