/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public Resume[] storage = new Resume[10000];
    private int storageSize = 0;

    void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
        storageSize = 0;
    }

    void save(Resume r) {
        boolean resumeAlreadyExist = false;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                System.out.println("The Resume with id= " + r.uuid + " already exists.");
                resumeAlreadyExist = true;
                break;
            }
        }
        if (!resumeAlreadyExist) {
            storage[storageSize] = r;
            storageSize++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        boolean isDeleted = false;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[storageSize - 1];
                storageSize--;
                isDeleted = true;
                break;
            }
        }
        if (!isDeleted) {
            System.out.println("The Resume with id= " + uuid + " is not exist.");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[storageSize];
        for (int i = 0; i < storageSize; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return storageSize;
    }
}
