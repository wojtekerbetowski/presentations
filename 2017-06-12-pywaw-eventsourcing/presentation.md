# Event Sourcing
## In Django

Wojtek Erbetowski
PyWaw, 12.06.2017

---

### A long time ago...
^ My story of ignoring customers
^ * first job, learning from others
^ * rsync, vim, 6gb of ram
^ * idiots
^ * not understanding basics...
^ * then had a good leader
^ * how could we help more
^ * plan architecture for changes
^ * more generic arch, thinking of more cases

---

## What is the model architecture?

---

![fit](http://localhost:8000/012_flow.png)

---

![fit](http://localhost:8000/020_sides.png)

---

![fit](http://localhost:8000/030_model.png)

---

```python
class Book(Model):
    ...
    borrowed_by = models.ForeignKey(...)
    ...
```

---

```python
# Borrowing the book
book.borrowed_by = ...
book.save()
```

---

# Events

---

![fit](http://localhost:8000/040_deps.png)

---

![fit](http://localhost:8000/050_rm.png)

---

![fit](http://localhost:8000/060_changes.png)

---

Registration Event

```python
class BookBorrowed(Event):
    borrowed_by = models.CharField() # not a ref
```

---

Common event class

```python
class Event(Model):
    created = models.DateTimeField(auto_now_add=True)
```

---
^ all databases suck!

## Read models

---

Using signals for separation

```python
pre_save.connect(my_callback, sender='books.BookBorrowed')
```

---

### How to begin with?

---

### how's this affecting performance?

---

### Redundancy

---

### Performing a Full scan

---
^ Courier registers a parcel

### Validating events

---
and they lived happily ever after

---
![inline](http://localhost:8000/070_charity.png)

https://erbetowski.pl/charity

