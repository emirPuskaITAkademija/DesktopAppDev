package org.akademija.six.gui.ui;

import org.akademija.six.gui.dao.player.Player;
import org.akademija.six.gui.dao.sport.Sport;

public class PlayerWrapper {
    private final Player player;

    //DI Dependency Injection

    public PlayerWrapper(Player player){
        this.player = player;
    }

    public Object getColumValue(int index){
        switch (index){
            case 0: return player.getId();
            case 1: return player.getName();
            case 2: return player.getSurname();
            case 3: return  player.getSport();
            case 4: return player.getOfYears();
            case 5: return player.getVegetarian();
            case 6: return player.getFavouriteColor();
        }
        return null;
    }

    public void setColumValue(int index, Object aValue){
        switch (index){
//            case 0: player.setId((Long)aValue);break;  -> Jako dobar komentar je da nema potrebe za case 0.Id je nepromjenjljivo
            case 1: player.setName((String)aValue);break;
            case 2: player.setSurname((String) aValue);break;
            //case 3: player.setSport((Sport) aValue);break;
            case 4: player.setOfYears((Integer) aValue);break;
            case 5: player.setVegetarian((Boolean) aValue);break;
            case 6: player.setFavouriteColor((String)aValue);break;
        }
    }
}
