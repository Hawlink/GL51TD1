package gl51.service.impl

import com.sun.xml.internal.ws.util.InjectionPlan
import gl51.data.Photo
import gl51.service.PhotoService
import gl51.service.PhotoSavingService

import javax.inject.Inject

@Singleton
class PhotoSavingServiceImpl implements PhotoSavingService {

    @Inject
    PhotoService photoService

    @Inject
    LogoApplyService logoApplyService

    @Inject
    PhotoResizeService photoResizeService

    @Inject
    DataBaseUpdateService dataBaseUpdadeService

    @Override
    void savePhoto(Photo photo) {
        ///
    }



    /**
     * Fonction main
     */
    void mainFunction(int id){
        //Récupération de la photo
        Photo photoSource = photoService.getPhoto(id)

        //Redimensionnement de la photo en 1024
        Photo photo1024 = photoResizeService.resizePhoto(id)

        //Ajout du filigrane
        Photo photoLogo = logoApplyService.applyLogo(id)

        //Stockage dans le cloud
        savePhoto(photo1024)
        savePhoto(photoLogo)

        //Mise à jour de la base de données
        dataBaseUpdateService.updateDatabase()
    }
}
