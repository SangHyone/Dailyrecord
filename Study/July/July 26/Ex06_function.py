# *은 가변인수이다.
def add_many(*args):
    t = 0;
    for n in args:
        t += n
    return t


print(add_many(1, 2, 3))
print(add_many(1, 2, 3, 4, 5, 6))
# add_many((1, 2, 3, 4, 5, 6),(1,2),[1,2,3])
# add_many([1, 2, 3, 4, 5, 6])
