# Benennungskonzept (wichtigster Teil)

## Grundidee

- **EPICs** bekommen eine **stabile ID**
- **STORYs** referenzieren die EPIC-ID
- **TASKs** referenzieren EPIC + STORY
- Status wird **durch Ordner**, nicht durch Dateinamen abgebildet

## ID-Schema

```
EPIC-001
  └─ STORY-001
       └─ TASK-001
```

- IDs sind **laufend nummeriert**, unabhängig vom Status
- Kurz, lesbar, stabil

## Dateinamen-Schema

### EPIC

```
EPIC-001-image-backend.md
```

### STORY

```
EPIC-001-STORY-002-upload-endpoint.md
```

### TASK

```
EPIC-001-STORY-002-TASK-003-handle-multipart.md
```

### EPIC-Abschlussbericht

```
EPIC-001-image-backend-CLOSURE.md
```

## Ordnerstruktur (Beispiel)

```
/backlog

/inarbeit

/done
```

- EPICs bleiben oft lange im Backlog und dienen der Planung der nächsten sprints
- 
- EPIC-Abschlussbericht wird in inarbeit gespeichert