package com.easyconference.access;

import com.easyconference.domain.service.IConferenceService;
import com.easyconference.domain.entities.Conference;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author HSVSTT2
 */
public class ConferenceLinkedListRepository implements IConferenceService
{
    private LinkedList<Conference> listConference;
    public ConferenceLinkedListRepository (){
        this.listConference=new LinkedList();
    }
    
    @Override
    public boolean storeConference(Conference objConference) {
        boolean bandera=this.listConference.add(objConference);
        return bandera;
    }

    @Override
    public List<Conference> listConference() {
        return this.listConference;
    }
}
