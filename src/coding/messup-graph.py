import matplotlib.pyplot as plt

plt.figure(1)
plt.subplot(211)
plt.plot([12, 12, 12, 11, 12, 12, 11, 11, 10, 11])
plt.ylabel('Java Runtime (milliseconds)')

plt.subplot(212)
plt.plot([5, 4, 4, 4, 4, 4, 4, 4, 4, 4])
plt.ylabel('Python Runtime (milliseconds)')
plt.show()