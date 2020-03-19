package gl51.service.impl

import gl51.data.Photo
import gl51.service.PhotoService
import gl51.service.PhotoSavingService

import javax.inject.Inject

class PhotoSavingServiceImpl implements PhotoSavingService {

    @Inject
    PhotoService service

    @Override
    void savePhoto(int id) {
        Photo photo = service.getPhoto(id)
        ///
    }
}
